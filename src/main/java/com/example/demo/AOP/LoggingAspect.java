package main.com.example.demo.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * An Aspect for logging method executions.
 * The @Aspect annotation marks this class as an Aspect.
 * The @Component annotation makes this class a Spring component,
 * so Spring can manage it and enable AOP.
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Advice that runs BEFORE any method execution within the
     * com.example.demo.service package.
     *
     * Pointcut expression:
     * execution(* com.example.demo.service.*.*(..))
     * - *: any return type
     * - com.example.demo.service.*: any class within the service package
     * - .*: any method within those classes
     * - (..): any number and type of arguments
     *
     * @param joinPoint provides information about the intercepted method
     */
    @Before("execution(* com.example.demo.service.*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        // Get the method signature
        String methodName = joinPoint.getSignature().getName();
        // Get the target class name
        String className = joinPoint.getTarget().getClass().getName();

        System.out.println("AOP Log: Before executing method '" + methodName + "' in class '" + className + "'");
    }

    // You could add other types of advice like @After, @AfterReturning, @AfterThrowing, @Around
}