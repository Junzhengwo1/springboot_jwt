package com.kou.controller;

import com.kou.domain.User;
import com.kou.service.UserService;
import com.kou.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JIAJUN KOU
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Map<String,Object> login(User user){
        log.info("用户名：[{}]",user.getUsername());
        log.info("密码：[{}]",user.getPassword());
        Map<String,Object> map=new HashMap<>();

        try {
            User loginUser = userService.login(user);
            Map<String,String> payload=new HashMap<>();
            payload.put("username",loginUser.getUsername());
            //生成jwt令牌
            String token = JwtUtils.getToken(payload);

            map.put("state",true);
            map.put("msg","登陆成功");
            map.put("token",token);//响应token
        } catch (Exception e) {
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

}
