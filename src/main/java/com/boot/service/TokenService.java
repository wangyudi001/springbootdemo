package com.boot.service;

import com.boot.domain.User;

/**
 * @Author wangyudi
 * @Date 2019/4/16 11:15
 * @Version 1.0
 */
public interface TokenService {
    String getToken(User user);
}
