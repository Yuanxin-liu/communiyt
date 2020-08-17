package com.community.community.dao;

import com.community.community.bean.Application;
import com.community.community.bean.Resident;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDao {


    @Insert("insert into application(id,rid,out_time,in_time,actual_out_time,actual_in_time,reason,temperature,statu) values(#{id}, #{rid}, #{out_time}, #{in_time},#{actual_out_time},#{actual_in_time},#{reason},#{temperature},#{statu})")
    public void insertApplication(@Param("id") int id, @Param("rid") int rid,@Param("out_time") String out_time, @Param("in_time") String in_time, @Param("actual_out_time") String actual_out_tim, @Param("actual_in_time") String actual_in_time, @Param("reason") String reason,@Param("temperature") String temperature,@Param("statu") int statu);

    @Select("select * from application")
    public List<Application> getApplicationAll();

    @Select("select * from application where left(actual_out_time,10)=#{actual_out_time}")
    public List<Application> getApplicationByActualTime(@Param("actual_out_time") String actual_out_time);

    @Select("select * from application where left(out_time,10)=#{out_time}")
    public List<Application> getApplicationByTime(@Param("out_time") String out_time);

    @Select("select * from application where rid=#{rid}")
    public List<Application> getApplicationAllByRid(@Param("rid") int rid);

    @Select("select * from application where statu=#{statu}")
    public List<Application> getApplicationAllAuditing(@Param("statu") int statu);

    @Select("select * from application where statu=#{statu} and actual_out_time!=#{actual_out_time} and actual_in_time=#{actual_in_time}")
    public List<Application> getApplicationAllCon(@Param("statu") int statu,@Param("actual_out_time") String actual_out_time,@Param("actual_in_time") String actual_in_time);

    @Select("select * from application where rid=#{rid} and actual_out_time=#{actual_out_time} and statu=#{statu}")
    public List<Application> getApplicationedAllByRid(@Param("rid") int rid,@Param("actual_out_time") String actual_out_time,@Param("statu") int statu);

    @Update("update application set actual_out_time=#{actual_out_time} where id=#{id}")
    public void updateA(@Param("id") int id,@Param("actual_out_time") String actual_out_time);

    @Update("update application set statu=#{statu} where id=#{id}")
    public void updateAA(@Param("id") int id,@Param("statu") int statu);

    @Update("update application set actual_in_time=#{actual_in_time} where id=#{id}")
    public void updateAc(@Param("id") int id,@Param("actual_in_time") String actual_in_time);



}
