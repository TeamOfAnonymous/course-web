package com.gcc.course.repository;

import com.gcc.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huangMP on 2017/3/30.
 * decription :
 */
public interface CourseRepository extends JpaRepository<Course, String> {
}
