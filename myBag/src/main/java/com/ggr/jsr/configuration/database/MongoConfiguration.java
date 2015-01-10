package com.ggr.jsr.configuration.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories(value = "com.ggr.jsr.repository")
@ComponentScan(basePackages = {"com.ggr.jsr.repository"}, includeFilters = {
        @ComponentScan.Filter(Component.class),
        @ComponentScan.Filter(Repository.class)
})
public class MongoConfiguration extends AbstractMongoConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return "myBag";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}

	@Override
	@Bean(name = "mongoTemplate")
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}