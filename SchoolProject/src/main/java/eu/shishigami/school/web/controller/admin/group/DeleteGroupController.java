package eu.shishigami.school.web.controller.admin.group;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.service.GroupService;
import eu.shishigami.school.util.LoggingUtil;

@Component
@Scope(value = "session")
@Slf4j
public class DeleteGroupController {
	
	@Autowired
	private DeleteGroupView deleteGroupView;

	@Autowired
	private GroupService groupService;
	
	@PostConstruct
	public void init() {
		LoggingUtil.logInitialization(log);
	}
	
	public void handleSelect(GroupEntity groupEntity) {
		deleteGroupView.setGroupEntity(groupEntity);
		init();
	}
	
	public void handleDelete() {
		groupService.delete(deleteGroupView.getGroupEntity());
		LoggingUtil.logDelete(log);
	}
	
}
