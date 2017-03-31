package com.gcc.course.service.impl;

import com.gcc.course.domain.Session;
import com.gcc.course.repository.ArticleRepository;
import com.gcc.course.domain.Article;
import com.gcc.course.repository.SessionRepository;
import com.gcc.course.service.ArticleService;
import com.gcc.course.service.SessionService;
import com.gcc.course.utils.RequestResult;
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
    public RequestResult save(Article article) {
        RequestResult requestResult = new RequestResult();
        if (article.getId() == null || "".equals(article.getId())){
            article = articleRepository.save(article);
            requestResult.setSuccess(1);
            requestResult.setMessage("文章保存成功");
            requestResult.setObject(article);
        } else {
            requestResult.setSuccess(0);
            requestResult.setMessage("文章保存失败，该文章已存在");
        }
        return requestResult;
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
    public RequestResult update(Article article) {
        RequestResult requestResult = new RequestResult();
        try {
            articleRepository.update(article.getId(), article.getMdContent(), article.getTitle(), article.getSession());
            requestResult.setSuccess(1);
            requestResult.setMessage("文章修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            requestResult.setSuccess(0);
            requestResult.setMessage("文章修改失败");
        } finally {
            return requestResult;
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
