package com.gcc.course.service;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;

import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/20.
 */
public interface SectionService {

    Section save(Section section);

    Section get(String id);

    List<Section> findAll();

    boolean remove(Section section);

    Section update(Section section);

    Set<Section> findByCourse(Course course);
}
