package eu.shishigami.school.web.controller.admin.group;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value = "session")
@Getter
@Setter
public class GroupAdminView {

	private List<GroupEntity> allGroups;
	
}
