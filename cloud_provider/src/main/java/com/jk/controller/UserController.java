package com.jk.controller;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController{


    @Autowired
    private UserMapper userMapper;

/*
    @Value("${server.port}")
    String port;

    @GetMapping("testPro")
    @ResponseBody
    public String testPro(){
        System.out.println("ribbon调用生产者成功。。。。。。。。。");
        return "success--" + port;
    }

    @PostMapping("save")
    @ResponseBody
    public User save(@RequestBody User user){
        user.setUserId(Integer.parseInt(port));
       return user;
    }
    //分页查询用户信息
    @GetMapping("findAllUser")
    @ResponseBody
    public List<User> findAllUser(){
        return userService.findAllUser();
    }
*/
        //查询用户信息
        @GetMapping("findUserPage")
        @ResponseBody
        public List<User> findUserPage() {
            System.out.println("12132");
            return userMapper.findUserPage();
        }
    // 新增
    @PostMapping("saveUser")
    @ResponseBody
    public Boolean saveUser(@RequestBody User user) {
        try {

                userMapper.saveUser(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //回显
    @GetMapping("findUserInfoById")
    @ResponseBody
    public User findUserInfoById(Integer userId) {
        return userMapper.findUserInfoById(userId);


    }

    @PostMapping("select")
    @ResponseBody
    public String select(@RequestBody Integer id){
        System.out.println("feign调用生产者成功。。。");
        return "success";
    }

}

