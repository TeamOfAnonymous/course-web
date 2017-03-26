package com.gcc.course.repository;

import com.gcc.course.domain.Article;
import com.gcc.course.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * Created by WangZK on 2017/3/12.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 通过用户名和密码查找用户
     *
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameAndPassword(String userName, String password);

    /**
     * 根据id修改用户基本信息
     *
     * @param id
     * @param userName
     * @param password
     * @param authority
     */
    @Modifying
    @Transactional
    @Query("update User u set u.userName = ?2,u.password = ?3,u.authority = ?4  where u.id = ?1")
    void update(String id, String userName, String password, String authority);

    /**
     * 根据用户id修改删除时间和删除状态
     * @param id
     * @param deletedTime
     * @param is_deleted
     */
    @Modifying
    @Transactional
    @Query("update User u set u.deletedTime = ?2,u.is_deleted = ?3,u.authority = ?4  where u.id = ?1")
    void update(String id, LocalDateTime deletedTime, int is_deleted);
}
