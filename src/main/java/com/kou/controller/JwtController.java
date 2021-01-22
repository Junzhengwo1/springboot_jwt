package com.kou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JIAJUN KOU
 *
 * jwt令牌学习
 */
@RestController
public class JwtController {

    @GetMapping("/jwt")
    public String testJwt(String username, HttpServletRequest request){

        //相当于认证成功，把用户信息放入session
        request.getSession().setAttribute("username",username);


        return "login ok!";

    }

}
