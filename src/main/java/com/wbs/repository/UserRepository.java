package com.wbs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.wbs.domain.User;

@Repository
public class LoginRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(User user) {
		System.out.println("User :" + user);
		mongoTemplate.save(user);
	}
}
