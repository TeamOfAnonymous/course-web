package com.gcc.course.repository;

import com.gcc.course.domain.Course;
import com.gcc.course.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by WangZK on 2017/3/12.
 */
@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
    Set<Section> findByCourse(Course course);
}
