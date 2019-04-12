package com.jk.controller;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("select")
    public List<User> select() {
        System.out.println("京京加油！！！");
        //getForObject("http://生产者实例名/请求生产者的Controller方法", 返回值类型.class);
        List<User> result = restTemplate.getForObject("http://service-user/testPro", List.class);
        return result;
    }

    @PostMapping("save")
    public User save(){
        User user = new User();
        user.setUserName("苏大强");
        User user2 = restTemplate.postForObject("http://springcloud-user-reg/save",user, User.class);
        return user2;
    }


}
