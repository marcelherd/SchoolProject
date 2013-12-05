package eu.shishigami.school.auth;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.UserService;

@Component
@Scope(value = "session")
public class LoginController implements Serializable {
	
	@Autowired
	private UserService userService;

	public boolean isLoggedIn() {
		return SecurityContextHolder.getContext().getAuthentication().getName() != null ? true : false;
	}
	
	public boolean isAdmin() {
		if (isLoggedIn()) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			UserEntity user = userService.findByUsername(username);
			
			for (RoleEntity role : user.getGroup().getRoles()) {
				if (role.getRoleName().equals("ROLE_ADMIN")) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
