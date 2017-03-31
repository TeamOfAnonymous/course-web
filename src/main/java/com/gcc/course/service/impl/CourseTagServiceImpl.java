package com.gcc.course.service.impl;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.CourseTag;
import com.gcc.course.repository.CourseTagRepository;
import com.gcc.course.service.CourseTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription : 标签服务层实现
 */
@Service
public class CourseTagServiceImpl implements CourseTagService{

    @Autowired
    private CourseTagRepository courseTagRepository;

    @Override
    public CourseTag save(CourseTag courseTag) {
        return courseTagRepository.save(courseTag);
    }

    @Override
    public CourseTag get(String id) {
        return courseTagRepository.findOne(id);
    }

    @Override
    public CourseTag update(CourseTag courseTag) {
        return courseTagRepository.save(courseTag);
    }

    @Override
    public boolean remove(String id) {
        CourseTag item = courseTagRepository.findOne(id);
        item.delete();
        item = save(item);
        return item.isDeleted() ;
    }

    @Override
    public List<CourseTag> findAll() {
        return courseTagRepository.findAll();
    }
}
