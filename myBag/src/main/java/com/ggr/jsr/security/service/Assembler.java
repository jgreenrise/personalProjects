package com.ggr.jsr.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggr.jsr.security.domain.Account;

@Service("assembler")
public class Assembler {

	@Transactional(readOnly = true)
	Account buildUserFromUserEntity(Account userEntity) {

		String username = userEntity.getUsername();
		String password = userEntity.getPassword();
		String id = userEntity.getId();
		// boolean enabled = userEntity.isActive();
		// boolean accountNonExpired = userEntity.isActive();
		// boolean credentialsNonExpired = userEntity.isActive();
		// boolean accountNonLocked = userEntity.isActive();

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// for (SecurityRoleEntity role : userEntity.getRoles()) {
		// authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
		// }
		authorities.add(new SimpleGrantedAuthority("ADMIN"));

		// User user = new User(username, password, TRUE,
		// accountNonExpired, credentialsNonExpired, accountNonLocked,
		// authorities, id);

		Account user = new Account(username, password, true, true, true, true,
				authorities, id);

		return user;
	}
}