package com.fubukianime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fubukianime.domain.Quarter;
import com.fubukianime.domain.User;


public interface UserService extends IService<User> {

    User login(String username, String password);
}
