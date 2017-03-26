package com.gcc.course.web;

import com.gcc.course.service.ArticleService;
import com.gcc.course.service.SessionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/course")
@Api(value = "课程的后台管理Controller")
public class CourseAdminController {

    @Autowired
    private SessionService sessionServiceImpl;
}
