package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("springcloud-user-reg") //指定生产者的实例名称
public interface UserService {

  @GetMapping("select/{id}")
    public String select(@PathVariable Integer id);

    @GetMapping("findUserPage")
    public List<User> findUserPage();

    @PostMapping("saveUser")
    void saveUser( User user);

    @PostMapping("findUserInfoById")
    User findUserInfoById(Integer userId);
}
