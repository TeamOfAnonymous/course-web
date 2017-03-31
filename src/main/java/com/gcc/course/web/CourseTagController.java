package com.gcc.course.web;

import com.gcc.course.domain.CourseTag;
import com.gcc.course.service.CourseTagService;
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
@RequestMapping("/coursetag")
@Api(value = "标签的管理Controller")
public class CourseTagController {

    @Autowired
    private CourseTagService courseTagServiceImpl;

}
