package eu.shishigami.school.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.UserService;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userService.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " does not exist.");
		}

		boolean enabled = user.isEnabled();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getGroups()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(List<GroupEntity> groups) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (GroupEntity group : groups) {
			authorities.addAll(getAuthorities(group));
		}

		return authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(GroupEntity group) {
		List<GrantedAuthority> authorities = getGrantedAuthorities(group.getRoles());
		return authorities;
	}

	public List<GrantedAuthority> getGrantedAuthorities(List<RoleEntity> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (RoleEntity role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		return authorities;
	}

}
