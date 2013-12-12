package eu.shishigami.school.web.controller.admin.user;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.UserEntity;
import eu.shishigami.school.service.UserService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class DeleteUserController {
	
	@Autowired
	private DeleteUserView deleteUserView;

	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void init() {
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSelectUser(UserEntity userEntity) {
		deleteUserView.setUserEntity(userEntity);
		init();
	}
	
	public void handleDeleteUser() {
		userService.delete(deleteUserView.getUserEntity());
		LoggingUtil.logDelete(log);
	}
	
}
