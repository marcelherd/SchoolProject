package eu.shishigami.school.web.controller.admin.user;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.domain.UserEntity;

@Component
@Scope(value = "session")
@Getter
@Setter
public class AddUserView {
	
	private List<GroupEntity> allGroups;

	private UserEntity userEntity;
	
	private String password;
	
}
