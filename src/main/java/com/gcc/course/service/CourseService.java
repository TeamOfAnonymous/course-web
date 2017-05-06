package com.gcc.course.service;

import com.gcc.course.domain.Course;
import com.gcc.course.web.dto.WebResult;
import org.springframework.data.domain.Page;

/**
 * Created by huangMP on 2017/3/30.
 * decription : 课程服务层接口
 */
public interface CourseService {

    WebResult save(Course course);

    WebResult get(String id);

    WebResult update(Course course);

    WebResult remove(String id);

    WebResult findAll();

    WebResult getPageList(int page, int rows);

    WebResult findPageListByName(String name, int page, int rows);

    Page<Course> getCoursesForPage(Integer page, Integer size, String search);

    //根据id获取文章
    Course findById(String id);
}
