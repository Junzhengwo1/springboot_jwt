package com.kou.service.impl;

import com.kou.dao.UserDao;
import com.kou.domain.User;
import com.kou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JIAJUN KOU
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User loginUser = userDao.login(user);

        if(loginUser!=null){
            return loginUser;
        }
        throw new RuntimeException("登录错误");

    }
}
