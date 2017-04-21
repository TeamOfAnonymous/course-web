package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import com.gcc.course.utils.WebResult;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/12.
 */
public interface ArticleService {

    //保存文章
    WebResult save(Article article);

    //发布文章
    WebResult release(Article article);

    //发布文章
    WebResult release(String id);

    //获取文章列表
    List<Article> get();
    
    //获取分页的文章列表
    Page<Article> get(Integer page, Integer size, String searchStr);

    //根据id获取文章
    Article get(String id);

    //修改文章
    WebResult update(Article article);

    //删除文章
    boolean remove(String id);

    //恢复文章
    boolean recovery(String id);

    //通过文章id获取标签
    Set<Tag> getTags(String id);
}
