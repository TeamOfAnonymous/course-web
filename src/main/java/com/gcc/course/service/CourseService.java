package com.gcc.course.service;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.CourseTag;

import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription : 课程服务层接口
 */
public interface CourseService {

    Course save(Course course);

    Course get(String id);

    Course update(Course course);

    boolean remove(String id);

    List<Course> findAll();

    List<Course> getPageList(int page, int rows);
}
