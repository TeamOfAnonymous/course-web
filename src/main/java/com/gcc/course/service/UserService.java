package com.gcc.course.service;

import com.gcc.course.domain.User;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
public interface UserService {

    boolean save(User user);

    User findByUserNameAndPassword(String userName,String password);

    List<User> findAll();

    boolean update(User user);

    boolean remove(String id);

    boolean recovery(String id);

}
