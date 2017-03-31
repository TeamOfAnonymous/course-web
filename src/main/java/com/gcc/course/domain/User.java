package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by WangZK on 2017/3/20.
 */
@Entity
public class User extends BaseEntity {

    private String userName;
    private String password;
    private String authority; //权限

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime addTime; //添加用户的时间

    public User() {
        this.addTime = LocalDateTime.now();
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

}
