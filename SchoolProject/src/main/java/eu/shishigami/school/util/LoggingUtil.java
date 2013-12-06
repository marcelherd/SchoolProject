package eu.shishigami.school.util;

public class LoggingUtil {
	
	public static void logInitialization(org.slf4j.Logger log) {
		log.info("Initialized controller: " + log.getName());
	}

}
