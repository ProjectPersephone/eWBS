package com.wbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.Mongo;
import com.wbs.domain.User;

@Repository
public class UserRepository {

	public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new Mongo(), "wbs");
    }
	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(User user) {
		System.out.println("User :" + user);
		mongoTemplate.save(user);
	}
	
	public User getUser(String username) {
		Query query= new Query(Criteria.where("username").is(username));
		User user=mongoTemplate.findOne(query,User.class);
		System.out.println(user);
		return user;
	}
	
	public List<User> getAllUsers() {
		List<User> userList = mongoTemplate.findAll(User.class);
		return userList ;
	}

	public User authenticateUser(User user) {
		Query query= new Query(Criteria.where("username").is(user.getUsername()).and("password").is(user.getPassword()));
		User user2=mongoTemplate.findOne(query,User.class);
		return user2;
	}
}
