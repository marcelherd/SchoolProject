package eu.shishigami.school;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.service.RoleService;
import eu.shishigami.school.service.UserService;

@Slf4j
@Component
public class Initializer {

	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;

	@Autowired
	private RoleService roleService;

	public void init() {
//		RoleEntity userRole = new RoleEntity();
//		userRole.setRoleName("ROLE_USER");
//		userRole = roleService.save(userRole);
//		
//		RoleEntity adminRole = new RoleEntity();
//		adminRole.setRoleName("ROLE_ADMIN");
//		adminRole = roleService.save(adminRole);
//		
//		GroupEntity adminGroup = new GroupEntity();
//		adminGroup.setGroupName("Admin");		
//		adminGroup = groupService.save(adminGroup);
//		
//		UserEntity user = new UserEntity();
//		user.setUsername("Admin");
//		user.setPassword(new BCryptPasswordEncoder().encode("123qwe"));
//		user.setFirstName("Marcel");
//		user.setLastName("Herd");
//		user.setEmail("info@shishigami.eu");
//		user.setEnabled(true);
//		user = userService.save(user);
//		
//		List<RoleEntity> roles = new ArrayList<RoleEntity>();
//		roles.add(userRole);
//		roles.add(adminRole);
//		adminGroup.setRoles(roles);
//		
//		adminGroup = groupService.save(adminGroup);
//		
//		List<GroupEntity> groups = new ArrayList<GroupEntity>();
//		groups.add(adminGroup);
//		user.setGroups(groups);
//		
//		user = userService.save(user);
	}

}
