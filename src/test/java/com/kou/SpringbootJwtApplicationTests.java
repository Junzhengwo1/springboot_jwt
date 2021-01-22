package com.kou;

import com.kou.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootJwtApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {

    }

}
