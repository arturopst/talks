package com.aca.talks.service;

import com.aca.talks.domain.Rating;
import com.aca.talks.domain.Talk;
import com.aca.talks.repository.TalkRepository;
import com.aca.talks.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkServiceImpl implements TalkService {

    @Autowired
    private TalkRepository talkRepository;

    @Override
    public List<Talk> findAll() {
        return talkRepository.findAll();
    }

    @Override
    public List<Talk> findByUserId(Long id) {
        return talkRepository.findAll();
    }

    @Override
    public Talk findById(Long id) {
        return this.talkRepository.findById(id).orElse(null);
    }

    @Override
    public Talk save(Talk talk) {
        return talkRepository.save(talk);
    }

    @Override
    public void delete(Talk talk) {
        talkRepository.delete(talk);
    }

    @Override
    public Talk updateTalk(Talk talk) {
        return null;
    }

    @Override
    public Long calculateRating(Talk talk) {
        List<Rating> ratings = talk.getRatings();
        Long sum = 0L;
        Long res =0L;
        for (Rating rating : ratings){
            sum= sum+rating.getRating();
        }
        if (sum>0){
            res= sum/ratings.size();
        }
        return res;

    }


}
