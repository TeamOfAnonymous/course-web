package com.gcc.course.repository;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by WangZK on 2017/3/12.
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

}
