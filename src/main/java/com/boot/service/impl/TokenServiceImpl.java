package com.boot.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.boot.domain.User;
import com.boot.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author wangyudi
 * @Date 2019/4/16 11:17
 * @Version 1.0
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getUserId()).withExpiresAt(new Date(System.currentTimeMillis() + 3600000)).sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }
}
