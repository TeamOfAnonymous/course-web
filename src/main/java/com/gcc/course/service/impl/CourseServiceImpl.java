package com.gcc.course.service.impl;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import com.gcc.course.repository.CourseRepository;
import com.gcc.course.service.CourseService;
import com.gcc.course.service.SectionService;
import com.gcc.course.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SectionService sectionService ;

    @Override
    @Transactional
    public WebResult save(Course course) {
        return WebResult.ok(courseRepository.save(course)) ;
    }

    @Override
    @Transactional
    public WebResult get(String id) {
        Course course = courseRepository.findOne(id);
        insetSections(course);
        return WebResult.ok(course) ;
    }

    @Override
    @Transactional
    public WebResult update(Course course) {
        return WebResult.ok(courseRepository.save(course)) ;
    }

    @Override
    @Transactional
    public WebResult remove(String id) {
        Course item = courseRepository.findOne(id);
        // 先将其下内容删除
        if( item != null){
            if( item.getSections().size() > 0 ){
                Iterator<Section> sections = item.getSections().iterator();
                while( sections.hasNext() ){
                    Section section = sections.next();
                    section.delete();
                    sectionService.save(section);
                }
            }
        }
        // 再删除课程
        item.delete();
        item = courseRepository.save(item);
        return WebResult.ok( item.isDeleted() ) ;
    }

    @Override
    @Transactional
    public WebResult findAll() {
        List<Course> courses = courseRepository.findAll();
        insetSections(courses);
        return WebResult.ok( courses ) ;
    }

    @Override
    @Transactional
    public WebResult getPageList(int page, int rows){
        Pageable pageable = new PageRequest( page , rows ) ;
        Page<Course> result = courseRepository.findAll(pageable);
        insetSections( result.getContent() );
         return WebResult.ok(result);
    }


    private Course insetSections(Course course){
        if( null == course){
            Set<Section> sections = sectionService.findByCourse(course);
            course.setSections(sections);
        }
        return course;
    }
    private List<Course> insetSections(List<Course> courses){
        if( courses.size() > 0 ){
            for(Course course : courses){
                insetSections(course);
            }
        }
        return courses;
    }
}
