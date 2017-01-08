package com.cs.myapps.lenaDenaRozana.logging;

import org.apache.log4j.Logger;

public class LenaDenaLogger {
	
	public static Logger log = Logger.getLogger(LenaDenaLogger.class);

	public static Logger getLogger()
	{
		return log;
	}
}
