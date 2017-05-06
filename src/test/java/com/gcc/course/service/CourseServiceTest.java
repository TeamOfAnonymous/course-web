package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import com.gcc.course.domain.Tag;
import com.gcc.course.utils.WebResult;
import com.gcc.course.web.CourseAdminController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by WangZK on 2017/4/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private CourseAdminController courseAdminController;

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
        String id = "66ada6e0-9c29-47b0-acc3-b96b1f35bc36";
        Course course = (Course) courseService.get(id).getData();
        System.out.println(course.getSections().iterator().next().getName());
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

    @Test
    public void testSaveSection(){
        Course course = (Course) courseService.get("a72c2a7e-9d51-4316-ad15-bf13e70683c4").getData();
        course.setDescription("已修改");
        Section section = new Section();
        section.setName("测试章节2");
        section.setCourseId("a72c2a7e-9d51-4316-ad15-bf13e70683c4");
        section.setCourse(course);
        sectionService.save(section);
    }

    @Test
    public void testSave_Update(){


        Course course = new Course();
        course.setName("商业软件工程架构3");

        Section section = new Section();
        section.setName("测试章节3");
        section.setCourse(course);
        courseService.save(course);
        sectionService.save(section);
    }

    @Test
    public void testCourseController(){
        courseAdminController.get("4b831565-1829-4547-a452-5bc35789eeea");
    }

    @Test
    public void testSection(){
        Course course = (Course) courseService.get("4b831565-1829-4547-a452-5bc35789eeea").getData();
        //WebResult result = sectionService.findByCourse(course);
        //System.out.println(result.getData().toString());
    }
}
