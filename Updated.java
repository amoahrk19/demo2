@Component
class AttributeEngine {
    private final Map<String, AttributeCalculator> calculatorsByAttribute = new HashMap<>();

    public AttributeEngine(List<AttributeCalculator> calculatorBeans) {
        for (AttributeCalculator calc : calculatorBeans) {
            calculatorsByAttribute.put(calc.getAttributeName(), calc);
        }
    }

    public Dataset<Row> applyAttributes(Dataset<Row> dataset, Set<String> targetAttributes) {
        Set<String> datasetColumns = new HashSet<>(Arrays.asList(dataset.columns()));
        for (String attribute : targetAttributes) {
            dataset = computeAttribute(dataset, attribute, datasetColumns);
        }
        return dataset;
    }

    private Dataset<Row> computeAttribute(Dataset<Row> dataset, String attribute, Set<String> datasetColumns) {
        if (datasetColumns.contains(attribute)) return dataset;

        AttributeCalculator calculator = calculatorsByAttribute.get(attribute);
        if (calculator == null) {
            throw new IllegalArgumentException("Unknown attribute or column: " + attribute);
        }

        Map<String, Column> inputs = new HashMap<>();
        for (String dep : calculator.getInputColumns()) {
            if (!Arrays.asList(dataset.columns()).contains(dep)) {
                if (!calculatorsByAttribute.containsKey(dep)) {
                    throw new IllegalArgumentException("Missing input column and no calculator found: " + dep);
                }
                dataset = computeAttribute(dataset, dep, datasetColumns);
            }
            inputs.put(dep, functions.col(dep));
        }

        Column result = calculator.compute(inputs);
        dataset = dataset.withColumn(attribute, result);
        datasetColumns.add(attribute);

        return dataset;
    }
}
