package com.gcc.course.service.impl;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import com.gcc.course.repository.CourseRepository;
import com.gcc.course.repository.SectionRepository;
import com.gcc.course.service.CourseService;
import com.gcc.course.service.SectionService;
import com.gcc.course.utils.PageUtil;
import com.gcc.course.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
    private SectionService sectionService;


    @Override
    @Transactional
    public WebResult save(Course course) {
        return WebResult.ok(courseRepository.save(course));
    }

    @Override
    @Transactional
    public WebResult get(String id) {
        Course course = courseRepository.findOne(id);
<<<<<<< Updated upstream
        course = insertSection(course) ;
        return WebResult.ok(course) ;
=======
        return WebResult.ok(course);
>>>>>>> Stashed changes
    }

    @Override
    @Transactional
    public WebResult update(Course course) {
        return WebResult.ok(courseRepository.save(course));
    }

    @Override
    @Transactional
    public WebResult remove(String id) {
        Course item = courseRepository.findOne(id);
        // 先将其下内容删除
        if (item != null) {
            if (item.getSections().size() > 0) {
                Iterator<Section> sections = item.getSections().iterator();
                while (sections.hasNext()) {
                    boolean delFlag = (boolean) sectionService.remove(sections.next().getId()).getData();
                    if (!delFlag) {
                        throw new RuntimeException("删除课程出现错误 : " + sections.next().getName() + " 章节删除失败");
                    }
                }
            }
        }
        // 再删除课程
        item.delete();
        item = courseRepository.save(item);
        return WebResult.ok(item.isDeleted());
    }

    @Override
    @Transactional
    public WebResult findAll() {
        List<Course> courses = courseRepository.findAll();
<<<<<<< Updated upstream
        courses = insertSection(courses);
        return WebResult.ok( courses ) ;
=======
        return WebResult.ok(courses);
>>>>>>> Stashed changes
    }

    @Override
    @Transactional
    public WebResult getPageList(int page, int rows) {
        Pageable pageable = new PageRequest(page, rows);
        Page<Course> result = courseRepository.findAll(pageable);
<<<<<<< Updated upstream
        List<Course> courses = result.getContent();
        courses = insertSection(courses);
         return WebResult.ok(result);
=======
        return WebResult.ok(result);
>>>>>>> Stashed changes
    }

    @Override
    @Transactional
    public WebResult findPageListByName(String name, int page, int rows) {
        Course course = new Course();
        course.setName(name);
        // 定义查询规则
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("addTime")    // 忽略添加时间
                .withIgnorePaths("imgUrl")     // 忽略图片链接
                .withIgnorePaths("prompt")     // 忽略提示
                .withIgnorePaths("sortOrder")     // 忽略排序数
                .withIgnorePaths("description")    // 忽略描述
<<<<<<< Updated upstream
                .withIgnoreNullValues()
                ;
        Example example = Example.of(course , matcher);
        Page resultPage = courseRepository.findAll(example, new PageRequest( page , rows ));
        List<Course> courses = resultPage.getContent();
        courses = insertSection(courses);
        return WebResult.ok(resultPage);
    }


    private Course insertSection(Course course){
        course.setSections( sectionService.findByCourse(course) );
        return course;
    }

    private List<Course> insertSection(List<Course> courses){
        if( courses.size() > 0 ){
            for(Course course : courses){
                insertSection(course);
            }
        }
        return courses;
=======
                .withIgnoreNullValues();
        Example example = Example.of(course, matcher);
        Page resultPage = courseRepository.findAll(example, new PageRequest(page, rows));
        return WebResult.ok(resultPage);
    }

    //获取分页的课程列表
    public Page<Course> getCoursesForPage(Integer page, Integer size, String search) {
        Pageable pageable = PageUtil.basicPage(page, size);
        Page<Course> courses = courseRepository.findAll(pageable);
        return courses;
    }

    //根据id获取文章
    @Override
    public Course findById(String id) {
        return courseRepository.findOne(id);
>>>>>>> Stashed changes
    }

}
