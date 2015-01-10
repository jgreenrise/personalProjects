package com.ggr.jsr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ggr.jsr.domain.UserDataEntry;
import com.ggr.jsr.dto.Blog;
import com.ggr.jsr.repository.BlogRepository;
import com.ggr.jsr.response.ResponseAddBlog;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogsRepository;

	public static final String ACCOUNT_SID = "";
	public static final String AUTH_TOKEN = "";
	// Create a rest client
	final TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

	public ResponseAddBlog addBlog(Blog blog) throws TwilioRestException {
		// TODO Add new blog

		ResponseAddBlog res = new ResponseAddBlog();
		UserDataEntry domainObject = new UserDataEntry();
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		if (!StringUtils.isEmpty(blog.getMobileNumber()) && blog.getMobileNumber().length() == 10) {
			// Build the parameters
			params.add(new BasicNameValuePair("From", "+"));
			params.add(new BasicNameValuePair("To", "+1" + blog.getMobileNumber()));
			params.add(new BasicNameValuePair("Body", "Hola! Enjoy your free grocery bag. Keep shopping. Please provide this security code :" + blog.getCode()));

			MessageFactory messageFactory = client.getAccount().getMessageFactory();
			Message message = messageFactory.create(params);
			System.out.println(message.getSid());
		}

		domainObject.setName(blog.getName());
		domainObject.setEmailAddress(blog.getEmailAddress());
		domainObject.setMobileNumber(blog.getMobileNumber());
		domainObject.setSecretCode(blog.getCode());
		domainObject.setLastModified(new Date());

		if (blogsRepository.add(domainObject)) {
			res.setStatus("SUCCESS");
			res.setBlog(domainObject);
		} else {
			res.setStatus("FAILURE");
		}
		return res;
	}

}
