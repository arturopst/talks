package com.aca.talks.controller.api;

import com.aca.talks.domain.Rating;
import com.aca.talks.domain.Talk;
import com.aca.talks.domain.User;
import com.aca.talks.domain.dto.RatingDto;
import com.aca.talks.exception.ResourceNotFoundException;
import com.aca.talks.service.TalkService;
import com.aca.talks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TalkRestController {

    @Autowired
    private TalkService talkService;

    @Autowired
    private UserService userService;

    public TalkRestController(TalkService talkService){
        this.talkService = talkService;
    }

    @GetMapping("/api/talks")
    public List<Talk> findAll() {
        return talkService.findAll();
    }

    @GetMapping("/api/talks/{id}")
    public Talk getById(@PathVariable Long id) {
        Talk talk = talkService.findById(id);
        if(talk == null){
            throw new ResourceNotFoundException("Task", "id", id);
        }
        return talk;
    }

    @PostMapping("/api/talks")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@RequestBody Talk talk) {
        talkService.save(talk);
    }

    @DeleteMapping("/api/talks/{id}")
    public ResponseEntity<?> deleteTalk(@PathVariable Long id) {
        Talk talk = talkService.findById(id);
        if (talk == null) {
            throw new ResourceNotFoundException("Task", "id", id);
        }
        talkService.delete(talk);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/api/talks/{talkId}/rating")
    public void rateTalk(@PathVariable(value = "talkId") Long talkId, @RequestBody RatingDto ratingDto) {
        Talk talk = talkService.findById(talkId);
        if (talk == null) {
            throw new ResourceNotFoundException("Task", "id", talkId);
        }
        Rating rating = new Rating();
        User user = userService.findById(ratingDto.getUserId());
        if (user == null) {
            throw new ResourceNotFoundException("User", "user", talkId);
        }
        rating.setUser(user);
        rating.setTalk(talk);
        rating.setRating(ratingDto.getRating());
        List<Rating> ratingList = talk.getRatings();
        ratingList.add(rating);
        talk.setRatings(ratingList);
        talkService.save(talk);
    }

    @PutMapping("/api/talks/{id}")
    public void updateTalk(@PathVariable(value = "id") Long talkId, @RequestBody Talk talk) {
        Talk dbTalk = talkService.findById(talkId);
        if (dbTalk == null) {
            throw new ResourceNotFoundException("Task", "id", talkId);
        }
        dbTalk.setName(talk.getName());
        talkService.save(dbTalk);
    }


}
