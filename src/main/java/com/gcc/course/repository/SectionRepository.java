package com.gcc.course.repository;

import com.gcc.course.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by WangZK on 2017/3/12.
 */
@Repository
public interface SectionRepository extends JpaRepository<Section, String> {

}
