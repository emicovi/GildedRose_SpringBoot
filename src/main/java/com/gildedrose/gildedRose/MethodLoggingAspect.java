package com.gildedrose.gildedRose;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MethodLoggingAspect {

        private Logger logger = LoggerFactory.getLogger(MethodLoggingAspect.class);

        @Before("execution(* com.gildedrose.gildedRose.GildedRose.updateInventory(..))")
        public void logAdvice(final JoinPoint joinPoint) {
            logger.info("Method {} is called", joinPoint.getSignature().getName());
        }



}
