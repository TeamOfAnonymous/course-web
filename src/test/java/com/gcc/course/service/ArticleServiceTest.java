package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.repository.ArticleRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by Peivxuan on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//按方法定义顺序执行测试方法
@FixMethodOrder(MethodSorters.DEFAULT)
public class ArticleServiceImpTest {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章测试
     */
    @Test
    public void testSave() {
        Article article = new Article();
        boolean save = articleService.save(article);
        Assert.assertThat(save,is(true));
    }

    /**
     * 获取文章测试
     */
    @Test
    public void testGet() {
        String uuid = articleService.getArticleList("").get(0).getId();
        Assert.assertThat(articleService.get(uuid),notNullValue() );
    }

    /**
     * 获取文章集合测试
     */
    @Test
    public void testGetArticleList() {
        int size = articleService.getArticleList("").size();
        Assert.assertThat(size, greaterThan(0));
    }

    /**
     * 更新文章测试
     */
    @Test
    public void testUpdate() {
        String uuid = articleService.getArticleList("").get(0).getId();
        articleService.getArticleList("").get(0).setAuthor("thisistestname");
        articleService.save(articleService.getArticleList("").get(0));
        Article article = articleService.get(uuid);
        Assert.assertThat("thisistestname", is(article.getAuthor()));
    }

    /**
     * 移除文章测试
     */
    @Test
    public void testRemove() {
        String uuid = articleService.getArticleList("").get(0).getId();
        articleService.remove(uuid);
        Article article = articleService.get(uuid);
        Assert.assertThat(article,notNullValue());
    }
    
}
