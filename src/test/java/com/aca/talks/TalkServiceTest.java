package com.aca.talks;

import com.aca.talks.domain.Talk;
import com.aca.talks.repository.TalkRepository;
import com.aca.talks.service.TalkServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TalkServiceTest {


    @InjectMocks
    private TalkServiceImpl talkService;

    @Mock
    private TalkRepository repository;


    @Test
    public void testFindAll(){
        when(repository.findAll()).thenReturn(Arrays.asList(new Talk(),new Talk()));
        List<Talk> talks = talkService.findAll();
        assertEquals(2, talks.size());
    }

    @Test
    public void testFindById(){
        Talk talk = new Talk();
        talk.setId(1L);
        talk.setName("Unit testing");
        talk.setDescription("Unit testing review");
        talk.setUrl("www.codeproject.com");
       when(repository.findById(1L)).thenReturn(java.util.Optional.of(talk));
        Talk serviceTalk = talkService.findById(1L);
        assertEquals(talk.getName(),serviceTalk.getName());
    }
}
