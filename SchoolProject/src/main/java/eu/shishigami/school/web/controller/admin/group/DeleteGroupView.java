package eu.shishigami.school.web.controller.admin.group;

import lombok.Getter;
import lombok.Setter;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.domain.RoleEntity;

@Component
@Scope(value = "session")
@Getter
@Setter
public class DeleteGroupView {
	
	private DualListModel<RoleEntity> roleModel;

	private GroupEntity groupEntity;
	
}
