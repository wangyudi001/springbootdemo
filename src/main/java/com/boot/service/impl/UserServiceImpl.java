package com.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.UserDao;
import com.boot.domain.User;
import com.boot.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public Boolean delUserById(Integer id) {
        return userDao.delUserById(id) == 0 ? false : true;
    }

    @Override
    public Boolean updUserById(User user) {
        return userDao.UpdUserById(user) == 0 ? false : true;
    }

    @Override
    public Integer getCountByName(String username) {
        return userDao.getCountByName(username);
    }

    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user) == 0 ? false : true;
    }

}
