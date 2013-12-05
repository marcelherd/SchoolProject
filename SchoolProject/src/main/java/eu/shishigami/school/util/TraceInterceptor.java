package eu.shishigami.school.util;

import lombok.extern.slf4j.Slf4j;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

@Slf4j
public class TraceInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = 809858895002269817L;

	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) {
		if (ex != null) {
			log.debug(message, ex);
		} else {
			log.debug(message);
		}
	}
	
	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
		return true;
	}

}
