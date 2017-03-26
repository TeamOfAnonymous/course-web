package com.gcc.course.repository;

import com.gcc.course.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangZK on 2017/3/24.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

    List<Image> findByMd5Str(String md5Str);
}
