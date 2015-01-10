package com.ggr.jsr.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggr.jsr.dto.Blog;
import com.ggr.jsr.response.ResponseAddBlog;
import com.ggr.jsr.security.domain.Account;
import com.ggr.jsr.service.BlogService;
import com.twilio.sdk.TwilioRestException;

@RestController
@RequestMapping("/blog")
public class ApplicationController {
	
	@Autowired
	BlogService blogService;
	
	static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseAddBlog addBlog(Principal principal, @Valid @RequestBody Blog blog,
			BindingResult result) throws TwilioRestException {
		
		ResponseAddBlog res = new ResponseAddBlog();

		if (!result.hasErrors()) {
			logger.info("Request received to add a new contact.");
			return blogService.addBlog(blog);
		} else {
			logger.warn("Validation failed");
			res.setResult(result.getAllErrors());
		}

		return res;

	}

}
