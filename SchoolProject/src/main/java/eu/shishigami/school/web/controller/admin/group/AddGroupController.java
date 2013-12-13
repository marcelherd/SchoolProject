package eu.shishigami.school.web.controller.admin.group;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.domain.RoleEntity;
import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.service.RoleService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class AddGroupController {
	
	@Autowired
	private AddGroupView addGroupView;
	
	@Autowired
	private GroupService groupService;

	@Autowired
	private RoleService roleService;
	
	@PostConstruct
	public void init() {
		addGroupView.setGroupEntity(new GroupEntity());
		addGroupView.setRoleModel(new DualListModel<RoleEntity>(roleService.findAll(), new ArrayList<RoleEntity>()));
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSave() {
		addGroupView.getGroupEntity().setRoles(addGroupView.getRoleModel().getTarget());
		addGroupView.setGroupEntity(groupService.save(addGroupView.getGroupEntity()));
		LoggingUtil.logSave(log);
	}

}
