package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface UserMapper {


    List<User> findUserPage();

    void saveUser(@Param("user") User user);

    User findUserInfoById(Integer userId);



   /* @Select("select id as userId,username as userName,loginacct,userpswd,email,createtime from t_user")
    List<User> findAllUser();
    */
}
