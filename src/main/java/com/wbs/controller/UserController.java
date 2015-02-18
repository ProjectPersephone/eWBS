package com.wbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wbs.domain.User;
import com.wbs.service.UserService;

@Controller
@RequestMapping(value="/userController")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<String>("User created", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<String>("User updated", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateAll", method = RequestMethod.POST)
	public ResponseEntity<String> updateAll(@RequestBody List<User> users) {
		userService.updateAll(users);
		return new ResponseEntity<String>("All Users updated", HttpStatus.OK);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam(value = "emailId", required = true) String emailId) {
		User user = userService.getUser(emailId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/projectUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers(@RequestParam(value = "projectName", required = true) String projectName) {
		List<User> userList = userService.getUsers(projectName);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/otherUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getOtherUsers(@RequestParam(value = "projectName", required = true) String projectName) {
		List<User> userList = userService.getOtherUsers(projectName);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> authenticateUser(@RequestBody User user) {
		User user2 = userService.authenticateUser(user);
		if (user2 == null) {
			return new ResponseEntity<String>("incorrect username or password !", HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<User>(user2, HttpStatus.OK);
	}

	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseBody
	public ResponseEntity<?> duplicateKeyExceptionHandler(DuplicateKeyException e) {
		return new ResponseEntity<String>("User already Exists !", HttpStatus.CONFLICT);
	}
}
