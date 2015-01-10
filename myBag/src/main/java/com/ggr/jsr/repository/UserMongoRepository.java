package com.ggr.jsr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ggr.jsr.security.domain.Account;

@Repository
public interface UserMongoRepository extends MongoRepository<Account, String> {

	Account findByUsername(String username);
}
