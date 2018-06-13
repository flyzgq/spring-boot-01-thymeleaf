package com.fly.springboot.repository;

import com.fly.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Auther: fly
 * @Description: UserRepository 接口
 * @Date: 2018/5/5 16:32
 * @Modified By:
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User getById(Long id);

}
