package com.wbs.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.User;
import com.wbs.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user){
		userRepository.save(user);
	}

	public void updateUser(User user){
		userRepository.update(user);
	}
	
	public User getUser(String emailId) {
		return userRepository.getUser(emailId);
	}
	
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public User authenticateUser(User user) {
		return userRepository.authenticateUser(user);
	}

	public void sendMail(String mailId) {
		
	}

	public List<User> getUsers(String projectName) {
		return userRepository.getUsers(projectName);
	}

	public List<User> getOtherUsers(String projectName) {
		return userRepository.getOtherUsers(projectName);
	}

	public void updateAll(List<User> users) {
		userRepository.updateAll(users);
	}
}
