package com.gcc.course.web;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import com.gcc.course.service.ArticleService;
import com.gcc.course.utils.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public WebResult save(@RequestBody Article article) {
        return articleServiceImpl.save(article);
    }

    @PostMapping("release")
    @ApiOperation(value = "发布文章")
    public WebResult release(@RequestBody Article article) {
        return articleServiceImpl.release(article);
    }

    @GetMapping("release/{id}")
    @ApiOperation(value = "根据id发布文章")
    public WebResult release(@PathVariable String id) {
        return articleServiceImpl.release(id);
    }

    @PutMapping
    @ApiOperation(value = "更新文章")
    public WebResult update(@RequestBody Article article) {
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

    @GetMapping("getTags/{id}")
    @ApiOperation(value = "获取文章")
    public Set<Tag> getTags(@PathVariable String id) {
        return articleServiceImpl.getTags(id);
    }

    @GetMapping
    @ApiOperation(value = "获取文章列表")
    public List<Article> get() {
        return articleServiceImpl.get();
    }
}
