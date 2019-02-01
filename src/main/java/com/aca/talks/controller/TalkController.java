package com.aca.talks.controller;

import com.aca.talks.controller.Dto.TalkDto;
import com.aca.talks.domain.Talk;
import com.aca.talks.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        List<TalkDto> talkDto = new ArrayList<>();
        for (Talk talk : talks) {
            TalkDto dto = new TalkDto();
            dto.setId(talk.getId());
            dto.setName(talk.getName());
            dto.setDescription(talk.getDescription());
            dto.setUrl(talk.getUrl());
            dto.setRating(talkService.calculateRating(talk));
            talkDto.add(dto);
        }
        model.addAttribute("talks", talkDto);
        return "talks";
    }

    @RequestMapping("/talk/details")
    public String getTalkById(Model model, Long id) {
        Talk talk = talkService.findById(id);
        TalkDto talkDto = new TalkDto();
        if (talk != null) {
            talkDto.setId(talk.getId());
            talkDto.setName(talk.getName());
            talkDto.setDescription(talk.getDescription());
            talkDto.setUrl(talk.getUrl());
            talkDto.setRating(talkService.calculateRating(talk));
        } else {
            model.addAttribute("error", "Talk not found");
        }
        model.addAttribute("talk", talkDto);
        return "details";
    }

    @RequestMapping("/talk/ratings")
    public String getRatings(Model model, Long talkId) {
        Talk talk = talkService.findById(talkId);
        model.addAttribute("ratings", talk.getRatings());
        return "ratings";
    }


}
