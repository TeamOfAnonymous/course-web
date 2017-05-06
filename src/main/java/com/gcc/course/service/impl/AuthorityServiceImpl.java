package com.gcc.course.service.impl;

import com.gcc.course.domain.Authority;
import com.gcc.course.domain.AuthorityName;
import com.gcc.course.repository.AuthorityRepository;
import com.gcc.course.service.AuthorityService;
import com.gcc.course.web.dto.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangMP on 2017/5/6.
 * decription :
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public WebResult save(Authority authority) {
        if(nameIsTrue(authority.getName())){
            authority =  authorityRepository.save(authority);
            return WebResult.ok(authority);
        }
        return new WebResult(500,"权限名称错误",null);
    }

    @Override
    public WebResult get(String id) {
        Authority authority = authorityRepository.findOne(id);
        return WebResult.ok(authority);
    }

    @Override
    public WebResult update(Authority authority) {
        if(nameIsTrue(authority.getName())){
            authority =  authorityRepository.save(authority);
            return WebResult.ok(authority);
        }
        return new WebResult(500,"权限名称错误",null);
    }

    @Override
    public WebResult remove(String id) {
        authorityRepository.delete(id);
        if((get(id)==null?true:false)){
            return WebResult.ok();
        }
        return new WebResult(500,"该权限不存在",null);
    }

    @Override
    public WebResult findAll() {
        List<Authority> list = authorityRepository.findAll();
        return WebResult.ok(list);
    }

    @Override
    public WebResult fingByName(String name) {
        if(nameIsTrue(name)){
            Authority authority = authorityRepository.findByName(String.valueOf(name));
            return WebResult.ok(authority);
        }
        return new WebResult(500,"权限名称错误",null);
    }

    /**
     * 检查权限名称是否正确
     * @param name
     * @return
     */
    private boolean nameIsTrue( String name ){
        try{
            AuthorityName.valueOf(name);
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
