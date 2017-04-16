package com.gcc.course.service.impl;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import com.gcc.course.domain.Tag;
import com.gcc.course.repository.CourseRepository;
import com.gcc.course.repository.SectionRepository;
import com.gcc.course.repository.TagRepository;
import com.gcc.course.service.SectionService;
import com.gcc.course.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Peivxuan on 2017/3/20.
 */
@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public WebResult save(Section section) {
        section.setCourse(courseRepository.findOne(section.getCourseId()));
        for(Tag t : section.getTags()){
            tagRepository.save(t);
        }
        Section save = sectionRepository.save(section);
        return WebResult.ok(save);
    }

    @Override
    public WebResult get(String id) {
        Section section = null;
        try {
            section = sectionRepository.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return WebResult.ok(section);
        }
    }

    @Override
    public WebResult findAll() {
        return null;
    }

    @Override
    public WebResult remove(String id) {
        return WebResult.ok(this.sectionRepository.findOne(id).delete());
    }

    @Override
    public WebResult update(Section section) {
        return this.save(section);
    }

    @Override
    public WebResult findByCourse(Course course){
        return WebResult.ok(sectionRepository.findByCourse(course));
    }
}
