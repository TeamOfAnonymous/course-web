package com.gcc.course.repository;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WangZK on 2017/3/12.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    /**
     * 通过父节点查找文章
     *
     * @param session
     * @return
     */
    List<Article> findBySession(Session session);

    /**
     * 根据id修改删除时间和删除状态
     *
     * @param id
     * @param deletedTime
     * @param status
     */
    @Modifying
    @Transactional
    @Query("update Article a set a.deletedTime = ?2,a.status = ?3 where a.id = ?1")
    void update(String id, LocalDateTime deletedTime, int status);

    /**
     * 根据id修改基本信息
     *
     * @param id
     * @param mdContent
     * @param title
     * @param session
     */
    @Modifying
    @Transactional
    @Query("update Article a set a.mdContent = ?2,a.title = ?3,a.session = ?4 where a.id = ?1")
    Article update(String id, String mdContent, String title, Session session);
}
