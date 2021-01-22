package com.kou.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;


/**
 * @author JIAJUN KOU
 * jwt的工具类
 */
public class JwtUtils {

    private static final String SING="jzwkou";

    /**
     * 生成Token header.payload.sing
     */
    public static String getToken(Map<String,String> map){
        Calendar instance=Calendar.getInstance();
        //默认10天过期
        instance.add(Calendar.DATE,10);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //payLoad
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(instance.getTime())//指定过期时间
                .sign(Algorithm.HMAC256(SING));//sing

        return token;
    }

    /**
     * 验证token 合法性
     */
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(SING))
                .build().verify(token);

    }

    /**
     * 获取 token的信息
     */
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING))
                .build().verify(token);
        return verify;
    }


}
