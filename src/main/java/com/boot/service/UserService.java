package com.boot.service;

import com.boot.domain.User;

import java.util.List;

public interface UserService {
	User selectUserById(Integer userId);

	List<User> getAllUsers();
}
