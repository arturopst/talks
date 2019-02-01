package com.aca.talks.controller.api;

import com.aca.talks.domain.Rating;
import com.aca.talks.domain.Talk;
import com.aca.talks.service.TalkService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TalkRestController {

    @Autowired
    private TalkService talkService;

    @GetMapping("/api/talks")
    public List<Talk> findAll() {
        return talkService.findAll();
    }

    @GetMapping("/api/talks/{id}")
    public Talk getById(@PathVariable Long id) {
        return talkService.findById(id);
    }

    @RequestMapping(value = "/api/talks/save/", method = RequestMethod.POST)
    public void saveTalk(@RequestBody Talk talk) {
        talkService.save(talk);
    }

    @RequestMapping(value = "/api/talks/delete/{id}", method = RequestMethod.POST)
    public void deleteTalk(@PathVariable Long id) {
        Talk talk = talkService.findById(id);
        talkService.delete(talk);
    }

    @RequestMapping(value = "/api/talks/rate/{talkId}/rating", method = RequestMethod.POST)
    public void rateTalk(@PathVariable Long talkId, @RequestBody Rating rating) {
        Talk talk = talkService.findById(talkId);
        List<Rating> ratingList = talk.getRatings();
        ratingList.add(rating);
    }

    @RequestMapping(value = "/api/talks/update/talk", method = RequestMethod.POST)
    public void rateTalk(@RequestBody Talk talk) {
        talkService.save(talk);
    }


}
