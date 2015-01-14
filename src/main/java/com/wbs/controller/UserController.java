package com.wbs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wbs.domain.User;
import com.wbs.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user){
		userService.createUser(user);
		return new ResponseEntity<String>("User created", HttpStatus.OK);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam(value = "username", required = true) String username){
		User user = userService.getUser(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		List<User> userList= userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
}

