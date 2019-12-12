package com.cts.design.DesignPattern.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSinletonPattern {
	private static Logger loggerObj;
	private LoggerSinletonPattern(){
		
	}
	public static Logger getLoggerSinletonPattern(){
		if(loggerObj==null){
			return LoggerFactory.getLogger(LoggerSinletonPattern.class);
		}
		return loggerObj;
	}

}
