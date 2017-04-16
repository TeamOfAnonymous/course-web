package com.gcc.course.service;

import com.gcc.course.domain.Tag;

import java.util.Set;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2017/4/9.
 */
public interface TagService {
	Set<Tag> saveBySet(Set<Tag> tags);

	Tag findById(String id);


}
