package com.aca.talks.controller.api;

import com.aca.talks.domain.Talk;
import com.aca.talks.service.TalkService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TalkRestController {

    @Autowired
    private TalkService talkService;

    @GetMapping("/api/talks")
    public List<Talk> findAll(){
        return talkService.findAll();
    }

    @GetMapping("/api/talks/{id}")
    public Talk getById(@PathVariable Long id){
        return talkService.findById(id);
    }

}
