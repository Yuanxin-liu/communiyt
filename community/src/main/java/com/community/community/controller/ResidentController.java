package com.community.community.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSON;
import com.community.community.bean.Application;
import com.community.community.bean.Resident;
import com.community.community.bean.Resident;
import com.community.community.bean.User;
import com.community.community.dao.*;
import com.community.community.dao.ApplicationDao;
import com.community.community.dao.ResidentDao;
import com.community.community.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ResidentController {
    @Autowired
    ApplicationDao apd;
    @Autowired
    ResidentDao rd;
    @Autowired
    UserDao ud;
    List<Application> la;
    List<Resident> lr;

    //添加申请
    @RequestMapping("/addApplication")
    public String addApplication(@RequestBody Application a){
        String flag="error";

        System.out.println("a:"+a);

        //获得所有申请
        la=apd.getApplicationAll();
        int id=0;
        for(int i=0;i<la.size();i++){
            Application at=la.get(i);
            if(at.getId()>id)
                id=at.getId();

        }
        id++;
        System.out.println("id:"+id);

        //添加申请

        int rid=rd.getIdByName(a.getUsername());

        System.out.println("rid:"+rid);
        apd.insertApplication(id,rid,a.getOut_time(),a.getIn_time(),"0","0",a.getReason(),a.getTemperature(),0);

        flag="true";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("a",a);

        String res_json= JSON.toJSONString(res);
        System.out.println("flag:"+flag);
        return res_json;

    }

    //获取所有申请
    @RequestMapping("/getApplication")
    public String getApplicationAll(@RequestBody User u){
        System.out.print("user:"+u);
        int rid=rd.getIdByName(u.getUsername());
        la=apd.getApplicationAllByRid(rid);
        System.out.println("la:"+la);

        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("la",la);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有已经通过的申请
    @RequestMapping("/getApplicationed")
    public String getApplicationAlled(@RequestBody User u){
        System.out.print("user:"+u);
        int rid=rd.getIdByName(u.getUsername());
        la=apd.getApplicationedAllByRid(rid,"0",1);
        System.out.println("la:"+la);

        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("la",la);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //修改实际 离开时间
    @RequestMapping("/upa")
    public String updateAactualOutTime(@RequestBody Application a ){
        System.out.print("a:"+a);

        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);

        System.out.println(createdate);

        apd.updateA(a.getId(),createdate);



        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获得居民信息
    @RequestMapping("/rinfo")
    public String getRinfo(@RequestBody User u){
        System.out.print("user:"+u);
        int rid=rd.getIdByName(u.getUsername());
        Resident r=rd.getR(rid);
        System.out.println("r:"+r);

        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("r",r);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //更新居民信息
    @RequestMapping("/updateRinfo")
    public String updateRinfo(@RequestBody Resident r){
        System.out.print("ur:"+r);
        rd.updateR(r.getName(),r.getIdcard(),r.getSex(),r.getAddress(),r.getPhone());
        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("r",r);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //修改居民密码
    @RequestMapping("/updateRpwd")
    public boolean updateRpwd(@RequestBody HashMap<String,String> mpwd){


        System.out.println("mpwds:"+mpwd);

        String oldpass=mpwd.get("oldpass");
        String pass=mpwd.get("checkPass");
        String name=mpwd.get("username");

        System.out.println("oldpass"+oldpass);
        System.out.println("pass:"+pass);

        System.out.println("name:"+name);
        User u=ud.getUserByName(name);
        String cpass=u.getPassword();
        System.out.println("cpass:"+cpass);
        //判断输入密码是否正确
        if(!oldpass.equals(cpass)){
            return false;
        }
//        System.out.println("sjhm:"+sjhm);
        boolean flag=false;
        ud.updateUserpwd(name,pass);
        flag=true;


        return flag;

    }

    //获取居民当日体温
    @RequestMapping("/getTemperature")
    public String getTemperature(@RequestBody Resident r){
        System.out.print("r:"+r);
        String temperature = rd.getTemperatureByName(r.getName());

        return temperature;
    }

    //修改居民当日体温
    @RequestMapping("/updateRtemperature")
    public String updateRtemperature(@RequestBody Resident r){
        System.out.print("r:"+r);
        rd.updateRtemperature(r.getName(),r.getTemperature());

        return "success";
    }










}
