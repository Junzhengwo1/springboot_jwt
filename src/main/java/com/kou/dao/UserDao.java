package com.kou.dao;

import com.kou.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Joaquin
 */
@Mapper
@Repository
public interface UserDao {

//    @Select("select * from user where name=#{name} and password=#{password}")
    User login(User user);

}
