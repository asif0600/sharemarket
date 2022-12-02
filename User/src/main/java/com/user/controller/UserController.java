package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers") // this will be accessible only if user logs in successfully
	public ResponseEntity<?> getAllUsers()
	{
		List<User> userlist = userService.getAllUsers();
		if(userlist!=null)
		{
			return new ResponseEntity<List<User>>(userlist, HttpStatus.OK);
		}
		return new ResponseEntity<String>("User List is empty", HttpStatus.NO_CONTENT);
	}

}


