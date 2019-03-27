package com.boot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.boot.domain.User;

import java.util.List;

@Mapper
public interface UserDao {  
    User selectUserById(Integer userId);

    List<User> getAllUsers();
}
