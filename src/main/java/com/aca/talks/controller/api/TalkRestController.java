package com.aca.talks.controller.api;

import com.aca.talks.domain.Rating;
import com.aca.talks.domain.Talk;
import com.aca.talks.exception.ResourceNotFoundException;
import com.aca.talks.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/api/tasks")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody Talk talk) {
        talkService.save(talk);
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<?> deleteTalk(@PathVariable Long id) {
        Talk talk = talkService.findById(id);
        if (talk == null) {
            throw new ResourceNotFoundException("Task", "id", id);
        }

        talkService.delete(talk);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/api/talks/{talkId}/rate", method = RequestMethod.POST)
    public void rateTalk(@PathVariable(value = "talkId") Long talkId, @RequestBody Rating rating) {
        Talk talk = talkService.findById(talkId);
        List<Rating> ratingList = talk.getRatings();
        ratingList.add(rating);
        talk.setRatings(ratingList);
        talkService.save(talk);
    }

    @PutMapping("/api/talks/{id}")
    public void rateTalk(@PathVariable(value = "id") Long taskId, @RequestBody Talk talk) {
        talkService.save(talk);
    }


}
