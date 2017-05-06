package com.gcc.course.web.controller.admin;

import com.gcc.course.domain.Section;
import com.gcc.course.service.SectionService;
import com.gcc.course.web.dto.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/section")
@Api(value = "章节的后台管理Controller")
public class SectionAdminController {

    @Autowired
    private SectionService sectionServiceImpl;

    @PostMapping
    @ApiOperation(value = "保存课时")
    public WebResult save(@RequestBody Section section) {
        return sectionServiceImpl.save(section);
    }

    @PutMapping
    @ApiOperation(value = "更新课时")
    public WebResult update(@RequestBody Section section) {
        return sectionServiceImpl.update(section);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除课时")
    public WebResult delete(@PathVariable String id) {
        return sectionServiceImpl.remove(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取课时列表")
    public WebResult get(@PathVariable String id) {
        return sectionServiceImpl.get(id);
    }


}
