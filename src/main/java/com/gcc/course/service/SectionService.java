package com.gcc.course.service;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import com.gcc.course.utils.WebResult;

import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/20.
 */
public interface SectionService {

    WebResult save(Section section);

    WebResult get(String id);

    WebResult findAll();

    WebResult remove(String id);

    WebResult update(Section section);

    WebResult findByCourse(Course course);
}
