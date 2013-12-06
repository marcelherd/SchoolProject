package eu.shishigami.school.constant;

import lombok.Getter;
import lombok.Setter;

public enum RoleEnum {
	
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN");
	
	@Getter
	@Setter
	private String roleValue;
	
	private RoleEnum(final String roleValue) {
		this.roleValue = roleValue;
	}

}
