package com.gcc.course.service.impl;

import com.gcc.course.domain.Tag;
import com.gcc.course.repository.ArticleRepository;
import com.gcc.course.domain.Article;
import com.gcc.course.service.ArticleService;
import com.gcc.course.service.TagService;
import com.gcc.course.utils.PageUtil;
import com.gcc.course.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/12.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TagService tagServiceImpl;

    /**
     * 保存文章，如果文章已经存在，对文章进行更新
     *
     * @param article
     * @return
     */
    @Override
    public WebResult save(Article article) {
        WebResult webResult = null;
        String id = article.getId();
        article.setTags(article.getTagSet());
        article.setTags(tagServiceImpl.saveBySet(article.getTags()));
        articleRepository.save(article);
        if (null == id || "".equals(id)) {
            webResult = new WebResult(1, "文章保存成功", article);
        } else {
            if (articleRepository.findOne(id) == null) {
                webResult = new WebResult(1, "文章保存成功", article);
            } else {
                webResult = new WebResult(1, "文章更新成功", article);
            }
        }

        return webResult;
    }

    /**
     * 发布文章
     *
     * @param article
     * @return
     */
    @Override
    public WebResult release(Article article) {
        WebResult webResult = null;

        //将文章状态设置为发布
        article.setState(1);
        article.setTags(article.getTagSet());
        article.setTags(tagServiceImpl.saveBySet(article.getTags()));
        articleRepository.save(article);
        webResult = new WebResult(1, "文章发布成功", article);

        return webResult;
    }


    /**
     * 发布文章
     *
     * @param id
     * @return
     */
    @Override
    public WebResult release(String id) {
        WebResult webResult = new WebResult();
        Article article = articleRepository.findOne(id);
        if (article != null) {
            //将文章状态设置为发布
            article.setState(1);
            articleRepository.save(article);
            webResult.setStatus(1);
            webResult.setMsg("文章发布成功");
            webResult.setData(article);
        }
        return webResult;
    }

    /**
     * 获取文章列表
     *
     * @return
     */
    @Override
    public List<Article> get() {
        return articleRepository.findAll();
    }

    /**
     * 获取分页的文章列表
     *
     * @return
     */
    @Override
    public Page<Article> get(Integer page, Integer size, String searchStr) {
        Pageable pageable = PageUtil.basicPage(page, size);
        Page<Article> articles = articleRepository.findByStatus(0, pageable);
        return articles;
    }

    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    @Override
    public Article get(String id) {
        try {
            Article article = articleRepository.findOne(id);
            return article;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (InvalidDataAccessApiUsageException e) {
            return null;
        }
    }

    /**
     * 根据id获取标签
     *
     * @param id
     * @return
     */
    @Override
    public Set<Tag> getTags(String id) {
        try {
            Article article = articleRepository.findOne(id);
            return article.getTags();
        } catch (IllegalArgumentException e) {
            return null;
        } catch (InvalidDataAccessApiUsageException e) {
            return null;
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
        WebResult webResult = null;
        if (articleRepository.findOne(article.getId()) != null) {
            article.setTags(article.getTagSet());
            article.setTags(tagServiceImpl.saveBySet(article.getTags()));
            articleRepository.save(article);
            webResult = new WebResult(1, "文章修改成功", article);
        } else {
            webResult = new WebResult(0, "文章修改失败", null);
        }
        return webResult;
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
            Integer result = articleRepository.uploadStatusAndDeletedTimeById(1, LocalDateTime.now(), id);
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        } catch (InvalidDataAccessApiUsageException e) {
            return false;
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
            Integer result = articleRepository.uploadStatusAndDeletedTimeById(0, null, id);
            if (result == 1) {
                return true;
            } else {
                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        } catch (InvalidDataAccessApiUsageException e) {
            return false;
        }
    }
}
