package com.gcc.course.service.impl;

import com.gcc.course.domain.Session;
import com.gcc.course.repository.SessionRepository;
import com.gcc.course.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public boolean save(Session session) {
        return false;
    }

    @Override
    public Session get(String id) {
        Session session = null;
        try {
            session = sessionRepository.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return session;
        }
    }

    @Override
    public List<Session> findAll() {
        return null;
    }

    @Override
    public boolean remove(Session session) {
        return false;
    }

    @Override
    public boolean update(Session session) {
        return false;
    }
}
