package com.aca.talks;

import com.aca.talks.controller.api.TalkRestController;
import com.aca.talks.domain.Talk;
import com.aca.talks.service.TalkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TalkRestController.class)
public class TalkRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TalkService talkService;


    @Test
    public void controllerReturnsOK() throws  Exception{

        mockMvc.perform(get("/api/talks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void controllerReturnsTalkList() throws  Exception{

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

        mockMvc.perform(get("/api/talks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"ratings\": null ,\"user\":null,\"name\":\"Test\",\"description\":\"Test Talk\",\"url\":\"www.google.com\"}]"))
                .andReturn();
    }

}
