package com.fubukianime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubukianime.domain.Quarter;
import com.fubukianime.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from anime.user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password")  String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from anime.user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into anime.user values(null,#{username},#{password})")
    void add(User user);
}
