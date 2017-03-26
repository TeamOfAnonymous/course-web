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
public class User {

    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    private String id;

    private String userName;
    private String password;
    private String authority; //权限

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime addTime; //添加用户的时间

    @Column(columnDefinition = "INT default 0")
    private int is_deleted; //是否被删除，1为true，0为false

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime deletedTime; //删除用户的时间

    public User() {
        this.addTime = LocalDateTime.now();
        this.is_deleted = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }
}
