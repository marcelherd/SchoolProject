package eu.shishigami.school.web.controller.admin.role;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.RoleEntity;

@Component
@Scope(value = "session")
@Getter
@Setter
public class RoleAdminView {
	
	private List<RoleEntity> allRoles;

}
