package com.gcc.course.service.impl;

import com.gcc.course.domain.User;
import com.gcc.course.repository.UserRepository;
import com.gcc.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    /**
     * 验证用户名和密码是否正确
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        User user = null;
        try {
            user = userRepository.findByUserNameAndPassword(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return user;
        }
    }

    /**
     * 查找所有的用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> users = null;
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    /**
     * 修改用户的基本信息
     *
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        try {
            userRepository.update(user.getId(), user.getUserName(), user.getPassword(), user.getAuthority());
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean remove(String id) {
        try {
            User user = userRepository.findOne(id);
            if (user != null) {
                userRepository.update(user.getId(), LocalDateTime.now(), 1);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    /**
     * 根据id恢复用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean recovery(String id) {
        try {
            User user = userRepository.findOne(id);
            if (user != null) {
                userRepository.update(user.getId(), null, 0);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }


}
