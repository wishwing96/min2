package com.min.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class SampleAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* com.min.service.Board_Service*.*(..))")
	public void startLog(JoinPoint jp) {
		/*
		logger.info("------------------");
		logger.info("------------------");
		logger.info(Arrays.toString(jp.getArgs()));
		*/
		System.out.println("------------------");
		System.out.println("------------------");
		System.out.println(Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* com.min.service.Board_Service*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
		long startTime = System.currentTimeMillis();
		System.out.println("startTime="+startTime);
		System.out.println(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		System.out.println("endTime="+endTime);
		System.out.println(pjp.getSignature().getName()+":"+(endTime - startTime));
		System.out.println("==================================");
		
		return result;
	}
}




























