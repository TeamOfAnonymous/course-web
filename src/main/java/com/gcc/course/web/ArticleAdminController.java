package com.gcc.course.web;

import com.gcc.course.domain.Article;
import com.gcc.course.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@RestController
@RequestMapping("admin/article")
@Api(value = "文章的后台管理Controller")
public class ArticleAdminController {

    @Autowired
    private ArticleService articleServiceImpl;

    @PostMapping
    @ApiOperation(value = "保存文章")
    public boolean save(@RequestBody Article article) {
        return articleServiceImpl.save(article);
    }

    @PutMapping
    @ApiOperation(value = "更新文章")
    public boolean update(@RequestBody Article article) {
        return articleServiceImpl.update(article);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除文章")
    public boolean delete(@PathVariable String id) {
        return articleServiceImpl.remove(id);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取文章")
    public Article get(@PathVariable String id) {
        return articleServiceImpl.get(id);
    }

    @GetMapping("getArticleList/{id}")
    @ApiOperation(value = "获取文章列表")
    public List<Article> getArticleList(@PathVariable String id) {
        return articleServiceImpl.getArticleList(id);
    }
}
