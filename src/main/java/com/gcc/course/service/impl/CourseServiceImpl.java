package com.gcc.course.service.impl;

import com.gcc.course.domain.Course;
import com.gcc.course.repository.CourseRepository;
import com.gcc.course.service.CourseService;
import com.gcc.course.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transient
    public WebResult save(Course course) {
        return WebResult.ok(courseRepository.save(course)) ;
    }

    @Override
    @Transient
    public WebResult get(String id) {
        return WebResult.ok(courseRepository.findOne(id)) ;
    }

    @Override
    @Transient
    public WebResult update(Course course) {
        return WebResult.ok(courseRepository.save(course)) ;
    }

    @Override
    @Transient
    public WebResult remove(String id) {
        Course item = courseRepository.findOne(id);
        item.delete();
        item = courseRepository.save(item);
        return WebResult.ok( item.isDeleted() ) ;
    }

    @Override
    @Transient
    public WebResult findAll() {
        return WebResult.ok( courseRepository.findAll() ) ;
    }

    /**
     * 分页查找
     * @param page 第几页
     * @param rows 一页几条
     */
    @Transient
    public WebResult getPageList(int page, int rows){
        Pageable pageable = new PageRequest( page , rows ) ;
        Page<Course> result = courseRepository.findAll(pageable);
         return WebResult.ok(result);
    }
}
