package com.gcc.course.service;

import com.gcc.course.domain.User;
import com.gcc.course.web.dto.WebResult;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
public interface UserService {

    WebResult save(User user);

    User findByUserNameAndPassword(String userName,String password);

    List<User> findAll();

    WebResult update(User user);

    boolean remove(String id);

    boolean recovery(String id);

    WebResult updatePassword(String username, String oldPassword, String newPassword);
}
