package com.fly.springboot;

import com.fly.springboot.entity.User;
import com.fly.springboot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01ThymeleafApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource);
        System.out.println(connection.toString());
    }

    @Test
    public void testUser(){

    }
}
