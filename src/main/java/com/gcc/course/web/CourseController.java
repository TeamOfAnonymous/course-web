package com.gcc.course.web;

import com.gcc.course.domain.Course;
import com.gcc.course.service.CourseService;
import com.gcc.course.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
@RestController
@RequestMapping("/course")
@Api(value = "课程的后台管理Controller")
public class CourseController {

    @Autowired
    private CourseService courseServiceImpl;

}
