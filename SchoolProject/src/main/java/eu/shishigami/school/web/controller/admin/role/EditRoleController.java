package eu.shishigami.school.web.controller.admin.role;

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
		editRoleView.setRawRoleName(denormalizeRoleName(editRoleView.getRoleEntity().getRoleName()));
		init();
	}
	
	public void handleSave() {
		editRoleView.getRoleEntity().setRoleName(normalizeRoleName(editRoleView.getRawRoleName()));
		roleService.save(editRoleView.getRoleEntity());
		LoggingUtil.logSave(log);
	}
	
	private String normalizeRoleName(String rawString) {
		return rawString.startsWith("ROLE_") ? StringUtils.upperCase(rawString) : "ROLE_" + StringUtils.upperCase(rawString);
	}
	
	private String denormalizeRoleName(String normalizedString) {
		return normalizedString.startsWith("ROLE_") ? StringUtils.upperCase(normalizedString).substring(5) : StringUtils.upperCase(normalizedString);
	}

}
