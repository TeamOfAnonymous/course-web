package com.gcc.course.web;

import com.gcc.course.domain.CourseTag;
import com.gcc.course.service.CourseTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huangMP on 2017/3/31.
 * decription :
 */
@RestController
@RequestMapping("admin/coursetag")
@Api(value = "标签的后台管理Controller")
public class CourseTagAdminController {

    @Autowired
    private CourseTagService courseTagServiceImpl;


    @PostMapping
    @ApiOperation(value = "保存标签")
    public CourseTag save(@RequestBody CourseTag courseTag) {
        return courseTagServiceImpl.save(courseTag);
    }

    @PutMapping
    @ApiOperation(value = "更新标签")
    public CourseTag update(@RequestBody CourseTag courseTag) {
        return courseTagServiceImpl.update(courseTag);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除标签")
    public boolean delete(@PathVariable String id) {
        return courseTagServiceImpl.remove(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取标签")
    public CourseTag get(@PathVariable String id) {
        return courseTagServiceImpl.get(id);
    }

    @GetMapping("getAll")
    @ApiOperation(value = "获取所有标签")
    public List<CourseTag> getAll() {
        return courseTagServiceImpl.findAll();
    }

}
