package com.community.community.dao;

import com.community.community.bean.Resident;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentDao {


    //添加住户
    @Insert("insert into resident(id,name,idcard,sex,address,phone,temperature) values(#{id}, #{name}, #{idcard}, #{sex},#{address},#{phone},#{temperature})")
    public void insertR(@Param("id") int id,@Param("name") String name,@Param("idcard") String idcard,@Param("sex") String sex,@Param("address") String address,@Param("phone") String phone,@Param("temperature") String temperature);


    @Select("select id from resident where name=#{name} ")
    public int getIdByName(@Param("name") String name);

    @Select("select temperature from resident where name=#{name} ")
    public String getTemperatureByName(@Param("name") String name);

    @Select("select name from resident where id=#{id} ")
    public String getNameById(@Param("id") int id);


    @Select("select id from resident")
    public List<Resident> getRidAll();

    @Select("select * from resident")
    public List<Resident> getRAll();

    @Select("select * from resident where id=#{id}")
    public Resident getR(@Param("id") int id);



    @Delete("delete from resident where idcard=#{idcard} ")
    public void deleteR(@Param("idcard") String idcard);

    @Update("update resident set name=#{name},sex=#{sex},address=#{address},phone=#{phone} where idcard=#{idcard}")
    public void updateR(@Param("name") String name,@Param("idcard") String idcard,@Param("sex") String sex,@Param("address") String address,@Param("phone") String phone);

    @Update("update resident set temperature=#{temperature} where name=#{name}")
    public void updateRtemperature(@Param("name") String name,@Param("temperature") String temperature);


}
