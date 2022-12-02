package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User addUser(User user);

	public boolean validateUser(String username, String password);

}
