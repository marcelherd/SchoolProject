package eu.shishigami.school.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class UtilityController {
	
	@Autowired
	private ServletContext servletContext;

	public String getContextPath() {
		return servletContext.getContextPath();
	}
	
}
