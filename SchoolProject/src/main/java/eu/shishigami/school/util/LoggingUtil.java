package eu.shishigami.school.util;

public class LoggingUtil {
	
	public static void logInitialization(org.slf4j.Logger log) {
		log.info("Initialized controller: " + log.getName());
	}
	
	public static void logSave(org.slf4j.Logger log) {
		log.info("Saved entity: " + log.getName());
	}
	
	public static void logDelete(org.slf4j.Logger log) {
		log.info("Deleted entity: " + log.getName());
	}

}
