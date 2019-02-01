package com.aca.talks;

import com.aca.talks.domain.Talk;
import com.aca.talks.repository.TalkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TalkRepositoryTest {

    @Autowired
    private TalkRepository repository;

    @Test
    public void testFindAll() {
        List<Talk> books = repository.findAll();
        assertEquals(1, books.size());
    }

}
