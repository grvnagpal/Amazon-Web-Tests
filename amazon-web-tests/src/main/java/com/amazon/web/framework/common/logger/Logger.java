package com.amazon.web.framework.common.logger;

import org.slf4j.LoggerFactory;
import org.testng.Reporter;

public class Logger {

	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);
	
	public static void action(String msg) {
		Reporter.log("[ACTION]: " + msg);
		LOGGER.info(msg);
	}
	
	public static void info(String msg) {
		Reporter.log("[INFO]: " + msg);
		LOGGER.info(msg);
	}
	
	public static void debug(String msg) {
		Reporter.log("[DEBUG]: " + msg);
		LOGGER.debug(msg);
	}
	
	public static void error(String msg) {
		error(msg, null);
	}

	public static void error(String msg, Exception e) {
		Reporter.log("[ERROR]: " + msg);
		LOGGER.error(msg, e);
	}
	
	public static void warn(String msg) {
		Reporter.log("[WARNING]: " + msg);
		LOGGER.warn(msg);
	}
	
	public static void trace(String msg) {
		Reporter.log("[TRACE]: " + msg);
		LOGGER.warn(msg);
	}
	
}