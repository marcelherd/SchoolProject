package eu.shishigami.school.web.controller.admin.user;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.service.UserService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class EditUserController {
	
	@Autowired
	private EditUserView editUserView;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@PostConstruct
	public void init() {
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSelectUser(UserEntity userEntity) {
		editUserView.setUserEntity(userEntity);
		editUserView.setAllGroups(groupService.findAll());
		init();
	}
	
	public void handleSave() {
		userService.save(editUserView.getUserEntity());
		LoggingUtil.logSave(log);
	}

}
