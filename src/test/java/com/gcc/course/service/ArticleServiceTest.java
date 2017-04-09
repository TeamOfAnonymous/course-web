package com.gcc.course.service;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

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
        article.setTitle("【第一天】01-HTML基础+02-HTML的标签（上）");
        article.setMdContent("测试");

        article.getTags().add(new Tag("HTML基础"));
        article.getTags().add(new Tag("HTML标签"));


    }

    /**
     * 测试发布文章的方法
     */
    @Test
    public void testRelease() {

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
