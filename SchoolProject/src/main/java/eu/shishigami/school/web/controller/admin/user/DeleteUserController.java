package eu.shishigami.school.web.controller.admin.user;

import lombok.extern.slf4j.Slf4j;

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
	private UserService userService;
	
	public void handleDeleteUser(UserEntity userEntity) {
		userService.delete(userEntity);
		LoggingUtil.logDelete(log);
	}
	
}
