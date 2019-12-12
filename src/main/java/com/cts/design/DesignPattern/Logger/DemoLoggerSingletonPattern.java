package com.cts.design.DesignPattern.Logger;

import org.slf4j.Logger;

public class DemoLoggerSingletonPattern 
{
    public static void main( String[] args )
    {
    	Logger obj1=LoggerSinletonPattern.getLoggerSinletonPattern();
    	Logger obj2=LoggerSinletonPattern.getLoggerSinletonPattern();
    	System.out.println("Logger Class Object 1-> "+obj1);
    	System.out.println("Logger Class Object 2-> "+obj2);
    	System.out.println("Is Both Object Equal ? "+obj1.equals(obj2));
    }
}
