package eu.shishigami.school.web.scope;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * Implements the JSF View Scope for use by Spring.
 * 
 * This class is registered as a Spring Bean with the CustomScopeConfigurer. All credits to :
 * http://comdynamics.net/blog/109/spring3-jsf2-view-scope/
 *
 */
public class ViewScope implements Scope {
	
	public Object get(String name, ObjectFactory<?> objectFactory) {
		if (FacesContext.getCurrentInstance().getViewRoot() != null) {
			Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
			
			if (viewMap.containsKey(name)) {
				return viewMap.get(name);
			} else {
				Object object = objectFactory.getObject();
				viewMap.put(name, object);
				return object;
			}
		} else {
			return null;
		}
	}
	
	public Object remove(String name) {
		if (FacesContext.getCurrentInstance().getViewRoot() != null) {
			return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
		} else {
			return null;
		}
	}
	
	public void registerDestructionCallback(String name, Runnable callback) { }
	
	public Object resolveContextualObject(String key) { return null; }
	
	public String getConversationId() { return null; }

}
