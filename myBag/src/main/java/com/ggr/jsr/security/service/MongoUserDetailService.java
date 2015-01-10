package com.ggr.jsr.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ggr.jsr.repository.UserMongoRepository;
import com.ggr.jsr.security.domain.Account;

import javax.inject.Inject;

@Service
public class MongoUserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MongoUserDetailService.class);
	
	@Autowired private Assembler assembler;

    @Inject
    private UserMongoRepository userMongoRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Account user = userMongoRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with name '" + username + "' doesn't exists.");
        }
        logger.debug("Found user '" + username + "' in database");

        return assembler.buildUserFromUserEntity(user);
    }

}
