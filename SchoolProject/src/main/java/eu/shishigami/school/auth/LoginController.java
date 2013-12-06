package eu.shishigami.school.auth;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import eu.shishigami.school.constant.RoleEnum;
import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.UserService;

@Component
@Scope(value = "session")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 3203688578110207694L;
	
	@Autowired
	private UserService userService;

	public boolean isLoggedIn() {
		return SecurityContextHolder.getContext().getAuthentication().getName() != null ? true : false;
	}
	
	public boolean isAdmin() {
		UserEntity user;
		return (user = getLoggedOnUser()) != null ? user.hasRole(RoleEnum.ADMIN.getRoleValue()) : false;
	}
	
	public UserEntity getLoggedOnUser() {
		if (isLoggedIn()) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userService.findByUsername(username);
		}
		
		return null;
	}
	
	public String getStatusAwareTemplate() {
		if (isLoggedIn()) {
			return "/WEB-INF/templates/mainLayout.xhtml";
		} else {
			return "/WEB-INF/templates/mainLayoutDenied.xhtml";
		}
	}
	
	public String getFallbackTarget(String contextPath) {
		if (isLoggedIn()) {
			return contextPath + "/pages/home.jsf";
		} else {
			return contextPath + "index.jsf";
		}
	}
	
}
