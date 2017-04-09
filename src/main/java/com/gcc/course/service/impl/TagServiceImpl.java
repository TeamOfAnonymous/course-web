package com.gcc.course.service.impl;

import com.gcc.course.domain.Tag;
import com.gcc.course.repository.TagRepository;
import com.gcc.course.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2017/4/9.
 */
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;

	@Override
	public Set<Tag> saveBySet(Set<Tag> tags) {

		Set<Tag> newTags =  new HashSet<>();

		for(Tag tag : tags){
			String name = tag.getName();
			if (tagRepository.findByName(name) == null) {
				newTags.add(tagRepository.save(tag));
			} else {
				newTags.add(tagRepository.findByName(name));
			}
		}

		return newTags;
	}

}
