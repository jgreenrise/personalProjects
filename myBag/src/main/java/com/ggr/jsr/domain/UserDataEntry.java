package com.ggr.jsr.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ggr.jsr.security.domain.Account;

import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

@Document(collection = "userDataEntries")
public class UserDataEntry {

	@Id
	private String id;

	@NotEmpty
	@Size(min = 2)
	private String name;

	private String emailAddress;

	private String mobileNumber;

	@NotEmpty
	@Size(min = 4, max = 4)
	private String secretCode;

	private Date lastModified;

	@Override
	public String toString() {
		return "UserDataEntry [id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + ", secretCode="
				+ secretCode + ", lastModified=" + lastModified + "]";
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getSecretCode() {
		return secretCode;
	}

}
