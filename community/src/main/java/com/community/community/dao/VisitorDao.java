package com.community.community.dao;

import com.community.community.bean.Application;
import com.community.community.bean.Visitor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorDao {

    @Insert("insert into visitor(id,name,sex,idcard,phone,out_time,in_time,reason,temperature) values(#{id}, #{name}, #{sex},#{idcard},#{phone},#{out_time}, #{in_time},#{reason},#{temperature})")
    public void insertVisitor(@Param("id") int id, @Param("name") String name,@Param("sex") String sex,@Param("idcard") String idcard,@Param("phone") String phone,@Param("out_time") String out_time, @Param("in_time") String in_time, @Param("reason") String reason, @Param("temperature") String temperature);

    @Select("select * from visitor")
    public List<Visitor> getAllVisitor();

    @Select("select * from visitor where left(in_time,10)=#{in_time}")
    public List<Visitor> getAllVisitorByTime(@Param("in_time") String in_time);

    @Select("select * from visitor where out_time=#{out_time} and in_time!=#{in_time}")
    public List<Visitor> getVisitorAllCon(@Param("out_time") String out_time,@Param("in_time") String in_time);

    @Update("update visitor set out_time=#{out_time} where idcard=#{idcard}")
    public void updateVc(@Param("idcard") String idcard,@Param("out_time") String out_time);



}
