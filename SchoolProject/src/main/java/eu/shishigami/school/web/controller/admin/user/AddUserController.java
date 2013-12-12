package eu.shishigami.school.web.controller.admin.user;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.service.UserService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class AddUserController {
	
	@Autowired
	private AddUserView addUserView;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@PostConstruct
	public void init() {
		addUserView.setUserEntity(new UserEntity());
		addUserView.setAllGroups(groupService.findAll());
		LoggingUtil.logInitialization(log);
	}
	
	public void handleCancel() {
		UserEntity userEntity = addUserView.getUserEntity();
		
		userEntity.setEmail("");
		userEntity.setEnabled(true);
		userEntity.setFirstName("");
		userEntity.setLastName("");
		userEntity.setPassword("");
		userEntity.setUsername("");
		
		addUserView.setUserEntity(userEntity);
	}
	
	public void handleSave() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = addUserView.getPassword();
		String encodedPassword = passwordEncoder.encode(rawPassword);
		addUserView.getUserEntity().setPassword(encodedPassword);
		
		addUserView.setUserEntity(userService.save(addUserView.getUserEntity()));
		
		LoggingUtil.logSave(log);
		
		handleCancel();
	}

}
