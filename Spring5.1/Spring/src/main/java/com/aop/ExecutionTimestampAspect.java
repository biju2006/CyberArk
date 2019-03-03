package com.aop;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimestampAspect {

	@Before("execution( * com.beans.ComposedBean.*(..))")
	public void measureTime(JoinPoint jp){
		Signature sign=jp.getSignature();
		System.out.println("AspectJ - "+sign.getName()+" was invoked on "+new Timestamp(System.currentTimeMillis()));
	}
}
