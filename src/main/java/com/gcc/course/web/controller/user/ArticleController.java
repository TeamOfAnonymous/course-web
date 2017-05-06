package com.gcc.course.web.controller.user;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import com.gcc.course.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/12.
 */
@RestController
@RequestMapping({"article"})
@Api(value = "前台-文章的Controller")
public class ArticleController {

    @Autowired
    private ArticleService articleServiceImpl;

    @GetMapping(value = "/getArticlesForPage")
    @ApiOperation(value = "获取分页的文章列表")
    public Page<Article> getArticlesForPage(@RequestParam Integer page, @RequestParam Integer size) {
        return articleServiceImpl.getArticlesForPage(page, size);
    }

    @GetMapping(value = "/getArticlesByTagForPage")
    @ApiOperation(value = "根据标签获取分页的文章列表")
    public Page<Article> getArticlesByTagForPage(@RequestParam String tid, @RequestParam Integer page, @RequestParam Integer size) {
        return articleServiceImpl.getArticlesByTagForPage(tid, page, size);
    }

    @GetMapping(value = "/getTags/{id}")
    @ApiOperation(value = "通过文章id获取文章的标签")
    public Set<Tag> getTags(@PathVariable String id) {
        return articleServiceImpl.getTags(id);
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "通过文章id获取文章")
    public Article get(@PathVariable String id) {
        return articleServiceImpl.get(id);
    }

}
