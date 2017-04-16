package com.gcc.course.repository;

import com.gcc.course.domain.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
