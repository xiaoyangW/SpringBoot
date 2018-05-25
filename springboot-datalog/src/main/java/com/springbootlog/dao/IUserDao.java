package com.springbootlog.dao;


import com.springbootlog.UserDataLog;
import com.springbootlog.module.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author WXY
 */
@Mapper
@Repository
public interface IUserDao {

    @UserDataLog(operation = "insert",msg = "添加用户")
    @Insert("insert into mydata.user(name,phone)value(#{name},#{phone});")
    Integer addUser(User user);

    @UserDataLog(operation = "delete",msg = "删除用户")
    @Delete("delete from mydata.user where id=#{id}")
    Integer delUser(Integer id);

    @UserDataLog(operation = "update",msg = "修改用户")
    @Update("update mydata.user set name=#{name},phone=#{phone} where id=#{id};")
    Integer updateUser(User user);

    @UserDataLog(operation = "update",msg = "修改用户信息")
    @Update("update mydata.user set name=#{name},phone=#{phone} where id=#{id};")
    Integer updateUser2(@Param("id") Integer id,@Param("name") String name,@Param("phone") String phone);

    @Results(id = "getuser",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "phone",property = "phone")
    })
    @Select("select id,name,phone from mydata.user where id=#{id}")
    User getUser(Integer id);
}
