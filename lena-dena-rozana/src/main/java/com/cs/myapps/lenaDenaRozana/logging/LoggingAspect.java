package com.cs.myapps.lenaDenaRozana.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect
{
	private static Logger log = Logger.getLogger("LenaDenaRozanaLogger"); 

	/** Following is the definition for a pointcut to select
	 *  all the methods available. So advice will be called
	 *  for all the methods.
	 */
	@Pointcut("execution(* com.cs.myapps.lenaDenaRozana.*.*(..))")
	private void selectAll(){}

	/**
	 * Log method entry.
	 * 
	 * @param joinPoint
	 */
	/** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	@Before("selectAll()")
	public void logEntry(final JoinPoint joinPoint)
	{
		System.out.println("CH****");
		log("Entering method " + joinPoint.getSignature().getName() + "...");
	}

	/**
	 * Log method exit.
	 * 
	 * @param joinPoint
	 */
	public void logExit(final JoinPoint joinPoint)
	{
		log("Exiting method " + joinPoint.getSignature().getName() + ".");
	}

	/**
	 * Log method exit after returning.
	 * 
	 * @param joinPoint
	 */
	 /** 
	    * This is the method which I would like to execute
	    * after a selected method execution.
	    */
	   @After("selectAll()")
	public void logExitAfterReturn(final JoinPoint joinPoint)
	{
		log(  "Exiting method (after return) "
				+ joinPoint.getSignature().getName() + ".");
	}

	/**
	 * "Log" the provided String.
	 * 
	 * @param messageToLog String to be logged.
	 */
	public static void log(final String messageToLog)
	{
		log.info(messageToLog);
		System.out.println(messageToLog);
	}
}
