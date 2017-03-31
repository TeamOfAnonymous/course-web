package com.gcc.course.service.impl;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.CourseTag;
import com.gcc.course.repository.CourseRepository;
import com.gcc.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
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
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transient
    public Course get(String id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public boolean remove(String id) {
        Course item = courseRepository.findOne(id);
        item.delete();
        item = save(item);
        return item.isDeleted() ;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    /**
     * 分页查找
     * @param page 第几页
     * @param rows 一页几条
     */
    public List<Course> getPageList(int page, int rows){
         return null;
    }
}
