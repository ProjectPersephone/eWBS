package com.wbs.repository;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.wbs.domain.User;
import com.wbs.util.MailService;

@Repository
public class UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private MailService mailService;

	public void save(User user) {
		String password = Integer.toString(new Random().nextInt(999999));
		user.setPassword(password);
		mongoTemplate.insert(user);
		mailService.sendMail(user);
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
		Query query= new Query(Criteria.where("emailId").is(user.getEmailId()).and("password").is(user.getPassword()));
		User user2=mongoTemplate.findOne(query,User.class);
		return user2;
	}
}
