package com.gcc.course.service.impl;

import com.gcc.course.domain.Section;
import com.gcc.course.domain.Tag;
import com.gcc.course.repository.SectionRepository;
import com.gcc.course.repository.TagRepository;
import com.gcc.course.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peivxuan on 2017/3/20.
 */
@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Section save(Section section) {
        for(Tag t : section.getTags()){
            tagRepository.save(t);
        }
        sectionRepository.save(section);
        return section;
    }

    @Override
    public Section get(String id) {
        Section section = null;
        try {
            section = sectionRepository.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return section;
        }
    }

    @Override
    public List<Section> findAll() {
        return null;
    }

    @Override
    public boolean remove(Section section) {
        return false;
    }

    @Override
    public Section update(Section section) {
        return sectionRepository.save(section);
    }
}
