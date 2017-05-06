package com.gcc.course.service.impl;

import com.gcc.course.domain.Authority;
import com.gcc.course.domain.User;
import com.gcc.course.repository.UserRepository;
import com.gcc.course.service.AuthorityService;
import com.gcc.course.service.UserService;
import com.gcc.course.web.dto.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityService authorityService;

    /**
     * 创建用户
     * @param user
     * @return
     */
    @Override
    public WebResult save(User user) {
        user = saveUserAuthorities(user);
        user = userRepository.save(user);
        return WebResult.ok(user);
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
            user = userRepository.findByUserName(userName);
            if(user!=null){
                if(user.getPassword().equals(password.trim())){
                    return user;
                }
            }
        return null;
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
    public WebResult update(User user) {
        user = saveUserAuthorities(user);
        user = userRepository.save(user);
        return WebResult.ok(user);
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
                user.delete();
                userRepository.save(user);
                //userRepository.update(user.getId(), LocalDateTime.now(), 1);
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
                user.setStatus(0);
                userRepository.save(user);
                //userRepository.update(user.getId(), null, 0);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    @Override
    public WebResult updatePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUserName(username);
        if( null != user ){
            if( user.getPassword().equals( oldPassword.trim() ) ){
                user.setPassword(newPassword);
                user = userRepository.save(user);
                return WebResult.ok(user);
            }
        }
        return new WebResult(500,"用户信息有误",user);
    }

    @Override
    public WebResult get(String id) {
        return WebResult.ok(userRepository.findOne(id));
    }

    /**
     * 保存用户的时候先把 其权限保存了
     * @param user
     * @return
     */
    public User saveUserAuthorities(User user){
        List<Authority> authorities = user.getAuthorities();
        if(authorities.size()>0){
            for(Authority authority : authorities){
                Authority authorityInDB = (Authority) authorityService.fingByName( authority.getName() ).getData();
                if( authorityInDB == null){
                    authorityService.save(authority);
                }else{
                    authority.setId(authorityInDB.getId());
                }
            }
        }
        return user;
    }


}
