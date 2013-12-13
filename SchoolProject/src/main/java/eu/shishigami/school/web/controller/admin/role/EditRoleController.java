package eu.shishigami.school.web.controller.admin.role;

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
public class EditRoleController {
	
	@Autowired
	private EditRoleView editRoleView;
	
	@Autowired
	private RoleService roleService;

	public void init() {
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSelect(RoleEntity roleEntity) {
		editRoleView.setRoleEntity(roleEntity);
		init();
	}
	
	public void handleSave() {
		roleService.save(editRoleView.getRoleEntity());
		LoggingUtil.logSave(log);
	}

}
