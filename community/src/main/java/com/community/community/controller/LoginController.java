package com.community.community.controller;


import com.alibaba.fastjson.JSON;
import com.community.community.dao.UserDao;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.community.community.bean.User;
import com.community.community.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;
    List<User> lu;

    //用户登录
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag="error";

        System.out.println("user:"+user);
//        lu=userDao.getUsers();
//        System.out.println("list user:"+lu);
//        System.out.println(user.getUsername());
 //       System.out.println(username);

        //根据用户输入的用户名查询数据库的该用户名对应的信息（密码，角色）
        User us=userDao.getUserByName(user.getUsername());
        //用户输入的密码
        String checkPass=us.getPassword();
        //如果密码正确可登陆到相应页面，否则返回错误
        if(checkPass.equals(user.getPassword())){
            //获得该用户的角色
            String role=us.getRole();
            //如果该用户是学生，返回s的标志
            if(role.equals("住户")){
                flag="resident";

            }
            //如果该用户是教授，返回t的标志
            if(role.equals("门卫")){
                flag="concierge";

            }
            //如果该用户是教授，返回t的标志
            if(role.equals("访客")){
                flag="visitor";

            }
            ////如果该用户是管理员，返回admin的标志
            if(role.equals("审核者")){
                flag="admin";

            }
        }

        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("user",user);

        String res_json=JSON.toJSONString(res);
        System.out.println("us:"+us);
        System.out.println("flag:"+flag);
        return res_json;

    }


}
