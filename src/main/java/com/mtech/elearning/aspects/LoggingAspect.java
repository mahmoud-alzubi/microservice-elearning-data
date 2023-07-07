package com.mtech.elearning.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /////////////////////////////////////////////////////////////

    /**
     * Repository Package Pointcut
     */
    @Pointcut("execution(* com.mtech.elearning.repository.*.*(..))")
    private void repositoryPackagePointcut() {
    }

    /////////////////////////////////////////////////////////////

    /**
     * Controller Package Pointcut
     */
    @Pointcut("execution(* com.mtech.elearning.controller.*.*(..))")
    private void controllerPackagePointcut() {
    }


    /////////////////////////////////////////////////////////////

    /**
     * Before Advice
     *
     * @param joinPoint
     */
    @Before("repositoryPackagePointcut() || controllerPackagePointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info(signature.toString());
    }


    /////////////////////////////////////////////////////////////

    /**
     * After Advice
     *
     * @param joinPoint
     */
    @After("repositoryPackagePointcut() || controllerPackagePointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("/" + signature.toString());
    }
}
