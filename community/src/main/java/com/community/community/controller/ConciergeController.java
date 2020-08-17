package com.community.community.controller;

import com.alibaba.fastjson.JSON;
import com.community.community.bean.Application;
import com.community.community.bean.Resident;
import com.community.community.bean.User;
import com.community.community.bean.Visitor;
import com.community.community.dao.*;
import com.community.community.dao.ApplicationDao;
import com.community.community.dao.ResidentDao;
import com.community.community.dao.UserDao;
import com.community.community.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class ConciergeController {

    @Autowired
    ResidentDao rd;
    @Autowired
    UserDao ud;
    @Autowired
    ApplicationDao ad;
    @Autowired
    VisitorDao vd;
    List<Application> la;
    List<Resident> lr;
    List<Visitor> lv;


    //修改门卫密码
    @RequestMapping("/updateCpwd")
    public boolean updateCpwd(@RequestBody HashMap<String,String> mpwd){


        System.out.println("mpwds:"+mpwd);

        String oldpass=mpwd.get("oldpass");
        String pass=mpwd.get("checkPass");

        System.out.println("oldpass"+oldpass);
        System.out.println("pass:"+pass);


        User u=ud.getUserByName("concierge");
        String cpass=u.getPassword();
        System.out.println("cpass:"+cpass);
        //判断输入密码是否正确
        if(!oldpass.equals(cpass)){
            return false;
        }
//        System.out.println("sjhm:"+sjhm);
        boolean flag=false;
        ud.updateUserpwd("concierge",pass);
        flag=true;


        return flag;

    }

    //获取已经确认外出的所有申请
    @RequestMapping("/getApplicationC")
    public String getApplicationC(){
        la=ad.getApplicationAllCon(1,"0","0");
        System.out.println("la:"+la);

        for(int i=0;i<la.size();i++){
            la.get(i).setUsername(rd.getNameById(la.get(i).getRid()));

        }

        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("la",la);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //确认访客回到社区时间
    @RequestMapping("/upac")
    public String updateAactualInTime(@RequestBody Application a ){
        System.out.print("a:"+a);

        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);

        System.out.println(createdate);

        ad.updateAc(a.getId(),createdate);



        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //获取所有未离开的来访者记录
    @RequestMapping("/getVisitorC")
    public String getVisitorC(){
        lv=vd.getVisitorAllCon("0","0");
        System.out.println("lv:"+lv);

        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);
        res.put("lv",lv);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }

    //更新来访者离开时间
    @RequestMapping("/upvc")
    public String updatVisitorOutTime(@RequestBody Visitor v ){
        System.out.print("v:"+v);

        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);

        System.out.println(createdate);

        vd.updateVc(v.getIdcard(),createdate);

        String flag="success";
        HashMap<String,Object> res=new HashMap();

        res.put("flag",flag);

        String res_json= JSON.toJSONString(res);
        return res_json;
    }


}
