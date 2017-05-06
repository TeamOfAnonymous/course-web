package com.gcc.course.web.controller.user;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import com.gcc.course.service.ArticleService;
import com.gcc.course.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WangZK on 2017/3/12.
 */
@RestController
@RequestMapping(value = "/tag")
@Api(value = "标签的前台Controller")
public class TagController {

    @Autowired
    private TagService tagServiceImpl;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有的标签", httpMethod = "GET")
    public List<Tag> getAll() {
        return tagServiceImpl.getAll();
    }


}
