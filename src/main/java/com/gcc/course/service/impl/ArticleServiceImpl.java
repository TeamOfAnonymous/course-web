package com.gcc.course.service.impl;

import com.gcc.course.domain.Section;
import com.gcc.course.repository.ArticleRepository;
import com.gcc.course.domain.Article;
import com.gcc.course.service.ArticleService;
import com.gcc.course.service.SectionService;
import com.gcc.course.utils.WebResult;
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
    private SectionService sectionServiceImpl;

    /**
     * 创建文章
     *
     * @param article
     * @return
     */
    @Override
    public WebResult save(Article article) {
        WebResult webResult = new WebResult();
        if (article.getId() == null || "".equals(article.getId())){
            article = articleRepository.save(article);
            webResult.setStatus(1);
            webResult.setMsg("文章保存成功");
            webResult.setData(article);
        } else {
            webResult.setStatus(0);
            webResult.setMsg("文章保存失败，该文章已存在");
        }
        return webResult;
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
            Section section = sectionServiceImpl.get(id);
            if (section != null) {
                articles = articleRepository.findBySection(section);
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
    public WebResult update(Article article) {
        WebResult webResult = new WebResult();
        try {
            articleRepository.update(article.getId(), article.getMdContent(), article.getTitle(), article.getSection());
            webResult.setStatus(1);
            webResult.setMsg("文章修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            webResult.setStatus(0);
            webResult.setMsg("文章修改失败");
        } finally {
            return webResult;
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
