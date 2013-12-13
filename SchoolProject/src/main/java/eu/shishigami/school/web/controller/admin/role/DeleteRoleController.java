package eu.shishigami.school.web.controller.admin.role;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.service.RoleService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class DeleteRoleController {
	
	@Autowired
	private DeleteRoleView deleteRoleView;

	@Autowired
	private RoleService roleService;
	
	@PostConstruct
	public void init() {
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSelect(RoleEntity roleEntity) {
		deleteRoleView.setRoleEntity(roleEntity);
		init();
	}
	
	public void handleDelete() {
		roleService.delete(deleteRoleView.getRoleEntity());
		LoggingUtil.logDelete(log);
	}
	
}
