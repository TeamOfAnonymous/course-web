package com.gcc.course.web;

import com.gcc.course.domain.Course;
import com.gcc.course.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/course")
@Api(value = "课程的后台管理Controller")
public class CourseAdminController {

    @Autowired
    private CourseService courseServiceImpl;


    @PostMapping
    @ApiOperation(value = "保存课程")
    public Course save(@RequestBody Course course) {
        return courseServiceImpl.save(course);
    }

    @PutMapping
    @ApiOperation(value = "更新课程")
    public Course update(@RequestBody Course course) {
        return courseServiceImpl.update(course);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除课程")
    public boolean delete(@PathVariable String id) {
        return courseServiceImpl.remove(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取课程")
    public Course get(@PathVariable String id) {
        return courseServiceImpl.get(id);
    }

    @GetMapping("getAll")
    @ApiOperation(value = "获取所有课程")
    public List<Course> getAll() {
        return courseServiceImpl.findAll();
    }
}
