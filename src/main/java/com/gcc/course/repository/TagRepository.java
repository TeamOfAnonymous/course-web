package com.gcc.course.repository;

import com.gcc.course.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2017/4/8.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    Tag findByName(String name);
}
