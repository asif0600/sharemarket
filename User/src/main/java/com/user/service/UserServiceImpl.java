package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		List<User> userlist = userRepo.findAll();
		if(userlist !=null && userlist.size()>0)
		{
			return userlist;
		}
		else
			return null;
	}

	@Override
	public User addUser(User user) 
	{
		if(user!=null)
		{
			return userRepo.saveAndFlush(user);
		}
		else
			return null;
	
	}

	@Override
	public boolean validateUser(String username, String password) 
	{
		User user = userRepo.validateUser(username, password);
		if(user!=null)
		{
			return true;
		}
		else
			return false;
	}
	
	
	

}
