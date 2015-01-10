package com.ggr.jsr.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Blog {

	@NotNull
	@Size(min = 2)
	private String name;

	private String emailAddress;

	private String mobileNumber;
	
	@NotNull
	@Size(max = 4)
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@Override
	public String toString() {
		return "Blog [name=" + name + ", emailAddress=" + emailAddress + ", mobileNumber=" + mobileNumber + ", code=" + code + "]";
	}

}
