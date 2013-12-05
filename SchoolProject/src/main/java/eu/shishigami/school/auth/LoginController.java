package eu.shishigami.school.auth;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session")
public class LoginController {

	public boolean isLoggedIn() {
		return SecurityContextHolder.getContext().getAuthentication().getName() != null ? true : false;
	}
	
	public boolean isAdmin() {
		if (isLoggedIn()) {
			Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
