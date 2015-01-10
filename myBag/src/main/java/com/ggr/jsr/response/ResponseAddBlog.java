package com.ggr.jsr.response;

import com.ggr.jsr.domain.UserDataEntry;

public class ResponseAddBlog extends JsonResponse {
	
	private UserDataEntry blog;

	public UserDataEntry getBlog() {
		return blog;
	}

	public void setBlog(UserDataEntry blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "ResponseAddBlog [blog=" + blog + "]";
	}

}
