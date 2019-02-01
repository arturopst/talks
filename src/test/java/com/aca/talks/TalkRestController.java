package com.aca.talks;

import com.aca.talks.domain.Talk;
import com.aca.talks.service.TalkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TalkRestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TalkService talkService;

    @Test
    public void talksApiReturnsTalkList() throws Exception{

        List<Talk> talks = new ArrayList<>();

        Talk talk = new Talk();
        talk.setId(1L);
        talk.setDescription("Test Talk");
        talk.setName("Test");
        talk.setUrl("www.google.com");
        talk.setRatings(null);
        talk.setUser(null);

        talks.add(talk);


        when(talkService.findAll()).thenReturn(talks);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/talks")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"ratings\":[],\"user\":null,\"name\":\"Test\",\"description\":\"Test Talk\",\"url\":\"www.google.com\"}"))
                .andReturn();
    }

}
