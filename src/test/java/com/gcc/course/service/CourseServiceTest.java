package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Course;
import com.gcc.course.domain.Tag;
import com.gcc.course.utils.WebResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by WangZK on 2017/4/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    /**
     * 测试添加课程
     */
    @Test
    public void testSave() {
        Course course = new Course();
        course.setName("商业软件工程架构");
        course = (Course) courseService.save(course).getData();
        assertThat(course).isNotNull();
        assertThat(course.getId()).isNotNull();
    }

    /**
     * 测试修改课程信息
     */
    @Test
    public void testUpdate() {
        Course course = (Course) courseService.get("bb316f3c-d042-40d2-8121-08f44ca33d78").getData();
        course.setDescription("这是一门有意思的课程");
        course = (Course) courseService.save(course).getData();
        assertThat(course.getDescription()).isEqualTo("这是一门有意思的课程");
    }

    /**
     * 获取所有课程
     */
    @Test
    public void testGetAll() {
        List<Course> courses = (List<Course>) courseService.findAll().getData();
        assertThat(courses.size()).isGreaterThan(0);
    }

    /**
     * 测试根据id查询课程
     */
    @Test
    public void testGetOne() {
        String id = "bb316f3c-d042-40d2-8121-08f44ca33d78";
        Course course = (Course) courseService.get(id).getData();
        assertThat(course).isNotNull();
    }

    /**
     * 测试删除课程
     */
    @Test
    public void testRemove() {
        String id = "ac7add1c-842f-4dcb-ac9e-db20baadc0fe";
        boolean result = (boolean) courseService.remove(id).getData();
        assertThat(result).isTrue();
    }
}
