package com.ggr.jsr.security.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ggr.jsr.enums.AccountType;
import com.ggr.jsr.enums.DataProviderType;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Document(collection = "users")
public class Account implements UserDetails {

	private static final long serialVersionUID = -8539884149020682992L;
	
	@Id
	private String id;
	private String username;
	private String displayName;
	private String password;

	private Integer securityQuestionId1;
	private String securityAnswer1;
	private Integer securityQuestionId2;
	private String securityAnswer2;

	private Collection<GrantedAuthority> authorities;

	private AccountType accountType = AccountType.MB;
	private Set<DataProviderType> dataProviders = new LinkedHashSet<DataProviderType>();
	
	public Account(){
	}

	public Account(String username, AccountType accountType, String displayName) {
		this.username = username;
		this.accountType = accountType;
		this.displayName = displayName;
	}

	public Account(String username, String password, Integer securityQuestionId1,
			String securityAnswer1, Integer securityQuestionId2,
			String securityAnswer2) {
		this(username, AccountType.MB, username);
		this.password = password;
		this.securityQuestionId1 = securityQuestionId1;
		this.securityAnswer1 = securityAnswer1;
		this.securityQuestionId2 = securityQuestionId2;
		this.securityAnswer2 = securityAnswer2;
	}

	public Account(String username, String password, boolean b, boolean c,
			boolean d, boolean e, Collection<GrantedAuthority> authorities,
			String id) {
		this(username, AccountType.MB, username);
		this.password = password;
		this.authorities = authorities;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSecurityQuestionId1() {
		return securityQuestionId1;
	}

	public void setSecurityQuestionId1(Integer securityQuestionId1) {
		this.securityQuestionId1 = securityQuestionId1;
	}

	public String getSecurityAnswer1() {
		return securityAnswer1;
	}

	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}

	public Integer getSecurityQuestionId2() {
		return securityQuestionId2;
	}

	public void setSecurityQuestionId2(Integer securityQuestionId2) {
		this.securityQuestionId2 = securityQuestionId2;
	}

	public String getSecurityAnswer2() {
		return securityAnswer2;
	}

	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Set<DataProviderType> getDataProviders() {
		return dataProviders;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
