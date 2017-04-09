package com.gcc.course.repository;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Session;
import org.apache.tomcat.util.http.fileupload.UploadContext;
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

    @Modifying
    @Transactional
    @Query("update Article a set a.status = ?1,a.deletedTime = ?2 where a.id = ?3")
    Integer uploadStatusAndDeletedTimeById(Integer status, LocalDateTime deletedTime, String id);
}
