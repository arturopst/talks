package com.aca.talks.controller;

import com.aca.talks.domain.Talk;
import com.aca.talks.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TalkController {

    @Autowired
    private TalkService talkService;

    @RequestMapping("/talks")
    public String getTalks(Model model) {
        List<Talk> talks = talkService.findAll();
        model.addAttribute("talks", talks);
        return "talks";
    }

    @RequestMapping("/talk/details")
    public String getTalkById(Model model, Long id) {
        Talk talk = talkService.findById(id);
        if (talk==null){
            model.addAttribute("error","Talk not found");
        }
        model.addAttribute("talk", talk);
        return "details";
    }



}
