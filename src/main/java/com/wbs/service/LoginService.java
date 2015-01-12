package com.wbs.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wbs.domain.User;
import com.wbs.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
		
	public void createUser(User user){
		loginRepository.save(user);
	}
}
