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
//		GroupEntity userGroup = new GroupEntity();
//		userGroup.setGroupName("User");
//		userGroup = groupService.save(userGroup);
//		
//		UserEntity adminUser = new UserEntity();
//		adminUser.setUsername("Admin");
//		adminUser.setPassword(new BCryptPasswordEncoder().encode("123qwe"));
//		adminUser.setFirstName("Marcel");
//		adminUser.setLastName("Herd");
//		adminUser.setEmail("info@shishigami.eu");
//		adminUser.setEnabled(true);
//		adminUser = userService.save(adminUser);
//		
//		UserEntity normalUser = new UserEntity();
//		normalUser.setUsername("User");
//		normalUser.setPassword(new BCryptPasswordEncoder().encode("123qwe"));
//		normalUser.setFirstName("Marcel");
//		normalUser.setLastName("Herd");
//		normalUser.setEmail("info@shishigami.eu");
//		normalUser.setEnabled(true);
//		normalUser = userService.save(normalUser);
//		
//		List<RoleEntity> rolesAdmin = new ArrayList<RoleEntity>();
//		rolesAdmin.add(userRole);
//		rolesAdmin.add(adminRole);
//		adminGroup.setRoles(rolesAdmin);
//		
//		adminGroup = groupService.save(adminGroup);
//		
//		List<RoleEntity> rolesUser = new ArrayList<RoleEntity>();
//		rolesUser.add(userRole);
//		userGroup.setRoles(rolesUser);
//		
//		userGroup = groupService.save(userGroup);
//		
//		List<GroupEntity> adminGroups = new ArrayList<GroupEntity>();
//		adminGroups.add(adminGroup);
//		adminUser.setGroups(adminGroups);
//		
//		adminUser = userService.save(adminUser);
//		
//		List<GroupEntity> userGroups = new ArrayList<GroupEntity>();
//		userGroups.add(userGroup);
//		normalUser.setGroups(userGroups);
//		
//		normalUser = userService.save(normalUser);
	}

}
