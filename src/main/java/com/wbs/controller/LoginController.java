package com.wbs.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wbs.domain.User;
import com.wbs.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService  loginService;
	
	@RequestMapping(value="/sample", method=RequestMethod.POST)
	public ResponseEntity<String> createRestaurant(@RequestBody User user){
		loginService.createUser(user);
		return new ResponseEntity<String>("Sample Created", HttpStatus.OK);
	}

}

