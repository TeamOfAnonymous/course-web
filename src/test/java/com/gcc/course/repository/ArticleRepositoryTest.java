package com.gcc.course.repository;

import com.gcc.course.domain.Article;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by WangZK on 2017/3/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//按方法定义顺序执行测试方法
@FixMethodOrder(MethodSorters.DEFAULT)
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testFindOne() {
        String id = "0eedd17a-907a-497a-82cb-40e0a363bdc6";
        Article article = articleRepository.findOne(id);
        System.out.println(article);
    }
}
