package com.gcc.course.web.controller.user;

import com.gcc.course.domain.Course;
import com.gcc.course.service.CourseService;
import com.gcc.course.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
@RestController
@RequestMapping({"course"})
@Api(value = "前台-课程服务",description = "提供课程的相关查询功能")
public class CourseController {

    @Autowired
    private CourseService courseServiceImpl;

    @GetMapping("/getCoursesForPage")
    @ApiOperation(value = "获取分页的课程列表")
    public Page<Course> getCoursesForPage(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String searchStr) {
        return courseServiceImpl.getCoursesForPage(page, size, searchStr);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据课程id获取课程")
    public Course getCoursesForPage(@PathVariable String id) {
        return courseServiceImpl.findById(id);
    }


}
