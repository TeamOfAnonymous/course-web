package com.gcc.course.service;

import com.gcc.course.domain.CourseTag;

import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription : 标签服务层接口
 */
public interface CourseTagService {

    CourseTag save(CourseTag courseTag);

    CourseTag get(String id);

    CourseTag update(CourseTag courseTag);

    boolean remove(String id);

    List<CourseTag> findAll();
}
