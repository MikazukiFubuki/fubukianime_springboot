package com.fubukianime.filter;

import com.alibaba.fastjson.JSON;
import com.fubukianime.controller.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查是否完成登录
 */
//@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取本次请求的URI
        String requestURI = request.getRequestURI();

        log.info("拦截到请求: {}", requestURI);

        //放行不需要处理数据
        String[]  urls = new String[]{
                "/user/login",
                "/user/logout",
                "/backend/**",
                "/pages/**",
                "/api/**",
                "/css/**",
                "/images/**",
                "/js/**",
                "/plugins/**",
                "/styles/**",
                "/vedio/**",
                "/index.html",
        } ;

        //判断本次请求是否处理
        boolean check = check(urls, requestURI);

        //如果不需要处理则放行
        if (check){
            log.info("本次请求{}不需要处理", requestURI);

            filterChain.doFilter(request, response);
            return;
        }

        //判断登陆状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user") != null){
            log.info("用户已登录,用户ID为：{}", request.getSession().getAttribute("user"));
            filterChain.doFilter(request, response);
            return;
        }

        log.info("用户未登录");

        //如果未登陆则返回未登录结果,通过输出流
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));



    }

    /**
     * 路径匹配，检查本次请求是否放行
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI){
        for (String url : urls){
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match){
                return true;
            }
        }
        return false;
    }
}
