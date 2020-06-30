package com.tcs.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspects {
	
	private static Logger logger =  Logger.getLogger(UserAspects.class);
	
	@Pointcut("execution(* com.tcs.*.*(..))")
	private void genericPointCut() {
		
	}
	
	@Before("genericPointCut()")
	public void infoLogs(JoinPoint jp) {
		System.out.println("Before calling " + jp.getTarget().getClass().getSimpleName() + " : " + jp.getTarget().getClass().getMethods());
		logger.debug("Before calling " + jp.getTarget().getClass().getSimpleName() + " : " + jp.getTarget().getClass().getMethods());
	}

	@Before("execution(public * getUserBy*(..))")
	public void logUserByIdRequests() {
		System.out.println("User was searched using userId: ");
		logger.debug("User was searched using userId: ");
	}
	
//	@AfterThrowing(pointCut = "genericPointCut() throws Exception", throwing = "ex")
//	public void exceptionLogs(JoinPoint jp, Exception ex) {
//		System.out.println(" " + jp.getTarget().getClass().getSimpleName() + " : " + jp.getTarget().getClass().getMethods() + " : " + ex.getMessage());
//		
//	}
}
