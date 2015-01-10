package com.ggr.jsr.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ggr.jsr.domain.UserDataEntry;

@Repository
public class BlogRepository {

	static final Logger logger = LoggerFactory.getLogger(BlogRepository.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * this will create a {@link Blog} collection if the collection does not
	 * already exists
	 * 
	 * public void createBlogsCollection() { if
	 * (!mongoTemplate.collectionExists(Blog.class)) {
	 * mongoTemplate.createCollection(Blog.class); } }
	 */

	/**
	 * this will drop the {@link Blog} collection if the collection does already
	 * exists
	 * 
	 * public void dropBlogsCollection() { if
	 * (mongoTemplate.collectionExists(Blog.class)) {
	 * mongoTemplate.dropCollection(Blog.class); } }
	 */

	/**
	 * Adds a new entry
	 * 
	 * @param user
	 */
	public Boolean add(UserDataEntry blog) {
		logger.debug("Adding a new entry");

		try {
			// Insert to db, if does not exists
			mongoTemplate.save(blog);

			return true;

		} catch (Exception e) {
			logger.error("An error has occurred while trying to add new contact", e);
			e.printStackTrace();
			return false;
		}
	}

}
