package com.ggr.jsr.security.domain;

import org.springframework.data.mongodb.core.mapping.Document;

public class SecurityRoleEntity {
	
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
