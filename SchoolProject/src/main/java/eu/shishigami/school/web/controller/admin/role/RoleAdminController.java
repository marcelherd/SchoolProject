package eu.shishigami.school.web.controller.admin.role;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.service.RoleService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class RoleAdminController {
	
	@Autowired
	private RoleAdminView roleAdminView;
	
	@Autowired
	private RoleService roleService;

	public void init() {
		roleAdminView.setAllRoles(roleService.findAll());
		
		LoggingUtil.logInitialization(log);
	}
	
}
