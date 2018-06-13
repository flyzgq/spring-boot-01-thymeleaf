package com.fly.springboot.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: fly
 * @Description: user实体
 * @Date: 2018/5/5 16:27
 * @Modified By:
 **/
@Entity
@Table(name = "jpa_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creat_time")
    private Date creatTime;
    public User() {

    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
