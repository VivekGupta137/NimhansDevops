package com.pe.nimhans.aop;

import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
@Configuration
public class LoggingAspect {
//	setup logger
	private Logger mylog = Logger.getLogger(getClass().getName());
	
	String currentUser= "not defined",currentRole= "not defined";
	Instant instant;
	
//	setup pointcut declarations
	@Pointcut("execution(* com.pe.nimhans.rest.*.*(..))")
	private void forRestPackage() {}
	
	@Pointcut("execution(* com.pe.nimhans.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.pe.nimhans.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forRestPackage() || forServicePackage()")
	private void forAppFlow() {}
	
//	set current user
	private void setCurrentUser() {
		Instant instant = Instant.now();		
		this.instant = instant;		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			this.currentUser = auth.getName();
			this.currentRole = auth.getAuthorities().toString();
		}
	}
	 
//	add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		setCurrentUser();
		String theMethod = theJoinPoint.getSignature().toShortString();
		String logString = "==> user["+this.currentUser+"] "+"role{"+currentRole+"} server_time["+instant+"] accessed: "+theMethod;
		mylog.info(logString);
	}
	

	
}
