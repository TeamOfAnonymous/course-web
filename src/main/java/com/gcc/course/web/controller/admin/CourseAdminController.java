package com.gcc.course.web.controller.admin;

import com.gcc.course.domain.Course;
import com.gcc.course.service.CourseService;
import com.gcc.course.web.dto.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/course")
@Api(value = "课程后台服务" , description = "提供课程的 增删改查 功能")
public class CourseAdminController {

    @Autowired
    private CourseService courseServiceImpl;

    @PostMapping
    @ApiOperation(value = "保存课程")
    public WebResult save(@RequestBody Course course) {
        return courseServiceImpl.save(course);
    }

    @PutMapping
    @ApiOperation(value = "更新课程")
    public WebResult update(@RequestBody Course course) {
        return courseServiceImpl.update(course);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除课程")
    public WebResult delete(@PathVariable String id) {
        return courseServiceImpl.remove(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取课程")
    public WebResult get(@PathVariable String id) {
        return courseServiceImpl.get(id) ;
    }

    @GetMapping("getAll")
    @ApiOperation(value = "获取所有课程")
    public WebResult getAll() {
        return courseServiceImpl.findAll();
    }

    @GetMapping("list")
    @ApiOperation(value = "分页查找课程,page=获取页的页码（第一页页码为0)->默认为0,rows=获取的条数->默认为10" )
    public WebResult getAll(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int rows) {
        return courseServiceImpl.getPageList( page , rows );
    }

    @GetMapping("findPageListByName")
    @ApiOperation(value = "分页查找课程(匹配 name ),page=获取页的页码（第一页页码为0)->默认为0,rows=获取的条数->默认为10")
            public WebResult findPageListByName(@RequestParam(defaultValue = "",required = false) String name ,@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int rows) {
        return courseServiceImpl.findPageListByName( name.trim() , page , rows );
    }
}
