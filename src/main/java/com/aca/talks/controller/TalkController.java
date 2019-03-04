package com.aca.talks.controller;

import com.aca.talks.domain.Talk;
import com.aca.talks.domain.TalkDto;
import com.aca.talks.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TalkController {

    @Autowired
    private TalkService talkService;

    @RequestMapping("/talks")
    public String getTalks(Model model) {
        List<Talk> talks = talkService.findAll();
        List<TalkDto> uiTalks = new ArrayList<>();
        TalkDto dto;
        for (Talk talk : talks){
            dto = new TalkDto();
            dto.setId(talk.getId());
            dto.setName(talk.getName());
            dto.setDescription(talk.getDescription());
            dto.setUrl(talk.getUrl());
            dto.setRating(talkService.calculateRating(talk));
            uiTalks.add(dto);
        }
        model.addAttribute("talks", uiTalks);
        return "talks";
    }

    @RequestMapping("/talk/details/{id}")
    public String getTalkById(Model model, @PathVariable Long id) {
        Talk talk = talkService.findById(id);
        if (talk==null){
            model.addAttribute("error","Talk not found");
            model.addAttribute("ratings",talk.getRatings());
        }
        model.addAttribute("talk", talk);
        return "details";
    }






}
