package com.gcc.course.service;


import com.gcc.course.domain.Authority;
import com.gcc.course.domain.AuthorityName;
import com.gcc.course.web.dto.WebResult;

/**
 * Created by huangMP on 2017/5/6.
 * decription :
 */
public interface AuthorityService {

    WebResult save(Authority authority);

    WebResult get(String id);

    WebResult update(Authority authority);

    WebResult remove(String id);

    WebResult findAll();

    WebResult fingByName(String name);
}
