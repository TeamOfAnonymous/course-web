package com.gcc.course.service;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by WangZK on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//按方法定义顺序执行测试方法
@FixMethodOrder(MethodSorters.DEFAULT)
public class ArticleServiceTest {
  
  @Autowired
    private ArticleService articleService;

    /**
     * 添加文章测试
     */
    @Test
    public void testSave() {
        Article article = new Article();
        articleService.save(article);
    }

    /**
     * 获取文章测试
     */
    @Test
    public void testGet() {
        String uuid = articleService.getArticleList("").get(0).getId();
        Assert.assertNotNull(articleService.get(uuid));
    }

    /**
     * 获取文章集合测试
     */
    @Test
    public void testGetArticleList() {
        int size = articleService.getArticleList("").size();
        Assert.assertNotNull(size);
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
        Assert.assertEquals("thisistestname", article.getAuthor());
    }

    /**
     * 移除文章测试
     */
    @Test
    public void testRemove() {
        String uuid = articleService.getArticleList("").get(0).getId();
        articleService.remove(uuid);
        Article article = articleService.get(uuid);
        Assert.assertNotNull(article);
    }
  
}
