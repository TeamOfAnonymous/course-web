package com.gcc.course.repository;

import com.gcc.course.domain.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by WangZK on 2017/4/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void testFindOne() {
        String id = "3f84b06c-536c-4ab3-8dcf-13a287a9f77e";
        Tag tag = tagRepository.findOne(id);
        System.out.println(tag.toString());
    }
}
