package com.community.community.dao;

import com.community.community.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Update("update user set password=#{password} where username=#{username}")
    public void updateUserpwd(@Param("username") String username,@Param("password") String password);

    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from user where username=#{username}")
    public  User getUserByName(@Param("username") String username);

}
