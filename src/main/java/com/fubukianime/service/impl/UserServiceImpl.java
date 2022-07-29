package com.fubukianime.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubukianime.dao.UserDao;
import com.fubukianime.domain.User;
import com.fubukianime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User login(String username, String password) {
        User user = userDao.select(username, password);
        return user;
    }
}
