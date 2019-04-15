package com.boot.service;

import com.boot.domain.User;

import java.util.List;

public interface UserService {
	User selectUserById(Integer userId);

	List<User> getAllUsers();

	User getUserByUsername(String username);

	Boolean delUserById(Integer id);

	Boolean updUserById(User user);

	Boolean addUser(User user);
}
