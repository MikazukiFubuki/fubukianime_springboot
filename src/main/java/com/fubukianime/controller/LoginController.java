package com.fubukianime.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fubukianime.controller.utils.R;
import com.fubukianime.domain.AnimeLove;
import com.fubukianime.domain.User;
import com.fubukianime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param request
     * @param user
     * @return
     */
    @PostMapping ("/login")
    public R login(HttpServletRequest request, @RequestBody User user){

        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User user1 = userService.getOne(queryWrapper);

        if (user1 == null){
            boolean flag = false;
            return new R(flag,"未找到此用户");
        }

        if (!user1.getPassword().equals(password)){
            boolean flag = false;
            return new R(flag,"密码错误");

        }

        if (user1.getDeleted() == 1){
            boolean flag = false;
            return new R(flag,"已被禁用");
        }

        request.getSession().setAttribute("user", user1.getId());

        return new R(true, user1);
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return new R(true,"退出成功");
    }
}
