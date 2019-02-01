package com.aca.talks;

import com.aca.talks.controller.TalkController;
import com.aca.talks.service.TalkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(TalkController.class)
public class TalkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TalkService talkService;


    @Test
    public void controllerReturnsTalksListView() throws  Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/talks");

        MvcResult result = mockMvc.perform(request)
                .andExpect(view().name("talks"))
                .andReturn();
    }

    @Test
    public void controllerReturnsTalksListViewWithTalksAtt() throws  Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/talks");

        MvcResult result = mockMvc.perform(request)
                .andExpect(view().name("talks"))
                .andExpect(model().attributeExists("talks"))
                .andReturn();
    }


}
