package com.gcc.course.service;

import com.gcc.course.domain.Session;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
public interface SessionService {

    boolean save(Session session);

    Session get(String id);

    List<Session> findAll();

    boolean remove(Session session);

    boolean update(Session session);
}
