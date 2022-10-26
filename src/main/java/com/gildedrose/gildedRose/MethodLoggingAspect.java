package com.gildedrose.gildedRose;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MethodLoggingAspect {

        private Logger logger = LoggerFactory.getLogger(MethodLoggingAspect.class);

        @Before("execution(* com.gildedrose.gildedRose.GildedRose.updateInventory(..))")
        public void logAdvice(final JoinPoint joinPoint) {
            logger.info("Method {} is called", joinPoint.getSignature().getName());
        }

        @AfterThrowing(pointcut = "execution(* com.gildedrose.gildedRose.GildedRose.updateInventory(..))", throwing = "ex")
        public void logAfterThrowing(final JoinPoint joinPoint, final Throwable ex) {
            logger.error("An exception has been thrown in {}() with cause = {}", joinPoint.getSignature().getName(), ex.getCause() != null ? ex.getCause() : "NULL");
        }

        @AfterReturning(pointcut = "execution(* com.gildedrose.gildedRose.GildedRose.updateInventory(..))", returning = "result")
        public void logAfterReturning(final JoinPoint joinPoint, final Object result) {
            logger.info("Method {} has returned with value = {}", joinPoint.getSignature().getName(), result);
        }
        




}
