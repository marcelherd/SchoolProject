package eu.shishigami.school.web.controller.admin.role;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.service.RoleService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class AddRoleController {
	
	@Autowired
	private AddRoleView addRoleView;
	
	@Autowired
	private RoleService roleService;
	
	@PostConstruct
	public void init() {
		addRoleView.setRoleEntity(new RoleEntity());
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSave() {
		addRoleView.getRoleEntity().setRoleName(normalizeRoleName(addRoleView.getRoleEntity().getRoleName()));
		addRoleView.setRoleEntity(roleService.save(addRoleView.getRoleEntity()));
		LoggingUtil.logSave(log);
	}
	
	private String normalizeRoleName(String rawString) {
		return rawString.startsWith("ROLE_") ? StringUtils.upperCase(rawString) : "ROLE_" + StringUtils.upperCase(rawString);
	}

}
