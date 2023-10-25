package com.ra.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("within(com.ra.api.*)")
    public void logApi(){}

    @Around("logApi()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Start {}.{} with params: {}", joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(),
                Arrays.asList(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed(); // cho phương thức xử lý
            LOGGER.info("End {}.{} return: {}", joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName(), result);
            return result;
        } catch (Exception ex) {
            LOGGER.error("Error {}.{} exception: {}", joinPoint.getSignature().getDeclaringType(), joinPoint.getSignature().getName(), ex);
            throw ex;
        }
    }
}
