package com.springbootlog.dao;


import com.springbootlog.module.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WXY
 */
@Mapper
@Repository
public interface IUserDao {
    @Insert("insert into mydata.user(name,phone)value(#{name},#{phone});")
    Integer addUser(User user);

}
