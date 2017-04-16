package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import com.gcc.course.utils.WebResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by WangZK on 2017/4/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    /**
     * 测试添加文章的方法
     */
    @Test
    public void testSave() {
        Article article = new Article();
        //article.setId("9b7f11ba-ccd8-43bb-b84a-58f0d7d06b2");
        article.setTitle("测试3");
        article.setMdContent("测试3");

        article.getTagSet().add(new Tag("HTML基础"));
        article.getTagSet().add(new Tag("HTML标签"));

        WebResult webResult = articleService.save(article);
        assertThat(webResult).isNotNull();
        assertThat(webResult.getMsg()).isEqualTo("文章保存成功");
    }

    /**
     * 测试发布文章的方法
     */
    @Test
    public void testRelease() {
        Article article = new Article();
        //article.setId("f2939c49-8a87-43dc-9e54-01e7d19cf567");
        article.setTitle("测试5");
        article.setMdContent("测试5");

        article.getTags().add(new Tag("测试1"));
        article.getTags().add(new Tag("测试2"));

        WebResult webResult = articleService.release(article);
        assertThat(webResult).isNotNull();
        assertThat(webResult.getMsg()).isEqualTo("文章发布成功");
    }

    /**
     * 根据id发布文章
     */
    @Test
    public void testReleaseById() {
        String id = "0eedd17a-907a-497a-82cb-40e0a363bdc6";
        WebResult webResult = articleService.release(id);
        Article article = (Article) webResult.getData();
        assertThat(article.getState()).isEqualTo(1);
    }

    /**
     * 获取文章列表
     */
    @Test
    public void testGetAll() {
        List<Article> articles = articleService.get();
        assertThat(articles.size()).isGreaterThan(0);
    }

    /**
     * 测试根据id查询文章
     */
    @Test
    public void testGetOne() {
        String id = "ac7add1c-842f-4dcb-ac9e-db20baadc0fe";
        String id1 = "ac7add1c-842f-4dcb-ac9e-db20baadc0f";
        String id2 = null;
        Article article = articleService.get(id);
        assertThat(article).isNotNull();
    }

    /**
     * 测试删除文章的方法
     */
    @Test
    public void testRemove() {
        String id = "ac7add1c-842f-4dcb-ac9e-db20baadc0fe";
        String id1 = "ac7add1c-842f-4dcb-ac9e-db20baadc0f";
        String id2 = null;
        boolean result = articleService.remove(id);
        assertThat(result).isTrue();
    }

    /**
     * 测试恢复文章的方法
     */
    @Test
    public void testRecovery() {
        String id = "ac7add1c-842f-4dcb-ac9e-db20baadc0fe";
        String id1 = "ac7add1c-842f-4dcb-ac9e-db20baadc0f";
        String id2 = null;
        boolean result = articleService.recovery(id);
        assertThat(result).isTrue();
    }
}
