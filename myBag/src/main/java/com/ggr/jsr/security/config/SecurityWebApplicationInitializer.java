package com.ggr.jsr.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends
		AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}

}