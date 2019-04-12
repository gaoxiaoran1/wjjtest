package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userlist")
    public String show1 (){
        return "userlist.html";
    }

    @GetMapping("select")
    @ResponseBody
    public String select(){

        String result = userService.select(123);

        return result;
    }
//查询
  @GetMapping("findUserPage")
   @ResponseBody
   public List<User> findUserPage() {
       System.out.println("121111132");
      List<User> list = userService.findUserPage();
      return list;

   }
//新增
@PostMapping("saveUser")
@ResponseBody
public void saveUser(User user) {

        userService.saveUser(user);
    }

    //回显
    @PostMapping("findUserInfoById")
    @ResponseBody
    public User findUserInfoById(Integer userId) {
        return userService.findUserInfoById(userId);


    }

}
