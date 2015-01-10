package com.ggr.jsr.security.config;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

/**
 * WARN: As of Spring Security 4.0, @EnableWebMvcSecurity is deprecated. The
 * replacement is @EnableWebSecurity which will determine adding the Spring MVC
 * features based upon the classpath.
 * 
 * To enable Spring Security integration with Spring MVC add the @EnableWebSecurity
 * annotation to your configuration.
 * 
 * @author JPatel
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.ggr.jsr" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@SuppressWarnings("deprecation")
//	public void addArgumentResolvers(
//			List<HandlerMethodArgumentResolver> argumentResolvers) {
//		argumentResolvers.add(new AuthenticationPrincipalArgumentResolver());
//		argumentResolvers
//				.add(new org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver());
//	}

	@Inject
	private com.ggr.jsr.security.service.MongoUserDetailService userDetailService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/resources/**", "/signup", "/about").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login")
				.permitAll().and().exceptionHandling().accessDeniedPage("/403");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin123")
				.roles("ADMIN");

		// The authentication provider below uses MongoDB to store SHA1 hashed
		// passwords
		// To see how to configure users for the example below, please see the
		// README file
		// auth.authenticationProvider(userDetailsService);
		auth.userDetailsService(userDetailService);
	}

}
