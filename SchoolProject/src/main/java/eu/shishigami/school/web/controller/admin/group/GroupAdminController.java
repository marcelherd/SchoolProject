package eu.shishigami.school.web.controller.admin.group;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class GroupAdminController {

	@Autowired
	private GroupAdminView groupAdminView;
	
	@Autowired
	private GroupService groupService;

	public void init() {
		groupAdminView.setAllGroups(groupService.findAll());
		
		LoggingUtil.logInitialization(log);
	}
	
}
