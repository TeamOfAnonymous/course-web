package com.gcc.course.service.impl;

import com.gcc.course.domain.Session;
import com.gcc.course.repository.ArticleRepository;
import com.gcc.course.domain.Article;
import com.gcc.course.repository.SessionRepository;
import com.gcc.course.service.ArticleService;
import com.gcc.course.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WangZK on 2017/3/12.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private SessionService sessionServiceImpl;

    /**
     * 创建文章
     *
     * @param article
     * @return
     */
    @Override
    public Article save(Article article) {
        try {
            article = articleRepository.save(article);
            return article;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过文章id获取文章
     *
     * @param id
     * @return
     */
    @Override
    public Article get(String id) {
        Article article = null;
        try {
            article = articleRepository.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return article;
        }
    }

    /**
     * 通过父节点id查找文章
     *
     * @return
     */
    @Override
    public List<Article> getArticleList(String id) {
        List<Article> articles = null;
        try {
            Session session = sessionServiceImpl.get(id);
            if (session != null) {
                articles = articleRepository.findBySession(session);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return articles;
        }
    }

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    @Override
    public boolean update(Article article) {
        try {
            articleRepository.update(article.getId(), article.getAuthor(), article.getMdContent(), article.getTitle(), article.getSession());
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }


    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @Override
    public boolean remove(String id) {
        try {
            Article article = articleRepository.findOne(id);
            if (article != null) {
                articleRepository.update(article.getId(), LocalDateTime.now(), 1);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    /**
     * 恢复文章
     *
     * @param id
     * @return
     */
    @Override
    public boolean recovery(String id) {
        try {
            Article article = articleRepository.findOne(id);
            if (article != null) {
                articleRepository.update(article.getId(), null, 0);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }
}
