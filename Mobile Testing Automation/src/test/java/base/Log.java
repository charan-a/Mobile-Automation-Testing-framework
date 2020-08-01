package base;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log {
	
    //Initialize Log4j instance
    private static Logger Log = Logger.getLogger(Log.class.getName());
    
    public void main(String[] args) {
    	BasicConfigurator.configure();
    }
    
    //We can use it when starting tests
    public static void startLog (){
        Log.info("Test is Starting...");
    }
 
    //We can use it when ending tests
    public static void endLog (){
        Log.info("Test is Ending...");
    }
 
    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }
 
    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }
 
    //Error Level Logs
    public static void error (String message, Exception e) {
        Log.error(message, e);
    }
 
    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }
 
    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}