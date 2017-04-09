package com.gcc.course.web;

import com.gcc.course.domain.Article;
import com.gcc.course.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WangZK on 2017/3/12.
 */
@RestController
@RequestMapping(value = "/article")
@Api(value = "文章的前台Controller")
public class ArticleController {

    @Autowired
    private ArticleService articleServiceImpl;

    @RequestMapping("/get")
    @ApiOperation(value = "获取文章",httpMethod = "POST")
    public Article get(@RequestParam String id) {
        return articleServiceImpl.get(id);
    }

    @GetMapping("articleList/{id}")
    @ApiOperation(value = "获取文章列表")
    public List<Article> getArticleList(@PathVariable String id) {
        return null;
    }

}
