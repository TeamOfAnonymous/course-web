package com.gcc.course.web.controller.admin;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import com.gcc.course.repository.TagRepository;
import com.gcc.course.service.ArticleService;
import com.gcc.course.service.TagService;
import com.gcc.course.utils.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/tag")
@Api(value = "标签的后台管理Controller")
public class TagAdminController {

    @Autowired
    private TagService tagServiceImpl;

    @GetMapping("{id}")
    @ApiOperation(value = "通过id获取标签")
    public Tag get(@PathVariable String id) {
        return tagServiceImpl.findById(id);
    }

}
