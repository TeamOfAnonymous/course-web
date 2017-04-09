package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.utils.WebResult;

import java.util.List;

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

    //根据id获取文章
    Article get(String id);

    //修改文章
    WebResult update(Article article);

    //删除文章
    boolean remove(String id);

    //恢复文章
    boolean recovery(String id);
}
