package eu.shishigami.school.web.controller.admin.group;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.service.RoleService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class EditGroupController {
	
	@Autowired
	private EditGroupView editGroupView;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private RoleService roleService;

	public void init() {
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSelect(GroupEntity groupEntity) {
		editGroupView.setGroupEntity(groupEntity);
		init();
	}
	
	public void handleSave() {
		groupService.save(editGroupView.getGroupEntity());
		LoggingUtil.logSave(log);
	}

}
