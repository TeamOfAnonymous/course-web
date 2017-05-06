package com.gcc.course.repository;

import com.gcc.course.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by huangMP on 2017/5/6.
 * decription :
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Authority findByName(String name);

}
