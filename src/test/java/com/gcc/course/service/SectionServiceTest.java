package com.gcc.course.service;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import com.gcc.course.domain.Tag;
import com.gcc.course.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by WangZK on 2017/4/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SectionServiceTest {

    @Autowired
    private SectionService sectionService;

    @Test
    public void save() throws Exception {
        Course course = new Course();
        course.setId("c53071ad-31bf-4538-ba7f-32dbddfeb7c5");

        Section section = new Section();
        section.setName("Bootstrap实践");
        section.setDescription("Bootstrap框架简介，Bootstrap基本使用、Bootstrap常用组件");

        section.getTags().add(new Tag("Bootstrap简介"));
        section.getTags().add(new Tag("Bootstrap组件"));

        section.setCourse(course);

        sectionService.save(section);

        Section section1 = new Section();
        section1.setName("HTML基础");
        section1.setDescription("前端HTML基础知识，包括页面结构、常用标签");

        section1.getTags().add(new Tag("HTML基础"));
        section1.getTags().add(new Tag("HTML5页面结构"));
        section1.getTags().add(new Tag("HTML标签"));

        section1.setCourse(course);

        sectionService.save(section1);

        Section section2 = new Section();
        section2.setName("CSS基础");
        section2.setDescription("前端CSS基础知识，包括CSS语法基础、CSS常用属性");

        section2.getTags().add(new Tag("CSS基础"));
        section2.getTags().add(new Tag("CSS语法基础"));
        section2.getTags().add(new Tag("CSS常用属性"));

        section2.setCourse(course);

        sectionService.save(section2);

        Section section3 = new Section();
        section3.setName("JavaScript基础 & jQuery & Ajax");
        section3.setDescription("前端JavaScript基础知识，包括JavaScript语法基础、JavaScript面向对象、jQuery基础、Ajax");

        section3.getTags().add(new Tag("JavaScript基础"));
        section3.getTags().add(new Tag("JavaScript面向对象"));
        section3.getTags().add(new Tag("jQuery基础"));
        section3.getTags().add(new Tag("Ajax基础"));

        section3.setCourse(course);

        sectionService.save(section3);

        Section section4 = new Section();
        section4.setName("Spring Boot Controller & Repository");
        section4.setDescription("Spring Boot框架简介、Spring Boot项目基础、Spring Boot Controller基础、Spring Boot JPA Repository基础");

        section4.getTags().add(new Tag("Spring Boot项目基础"));
        section4.getTags().add(new Tag("Spring Boot Controller基础"));
        section4.getTags().add(new Tag("JPA Repository基础"));

        section4.setCourse(course);

        sectionService.save(section4);

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void findByCourse() throws Exception {

    }

}