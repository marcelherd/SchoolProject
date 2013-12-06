package eu.shishigami.school.web.controller.admin;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.service.UserService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class UserAdminController {

	@Autowired
	private UserAdminView userAdminView;
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void init() {
		userAdminView.setAllUsers(userService.findAll());
		LoggingUtil.logInitialization(log);
	}
	
}
