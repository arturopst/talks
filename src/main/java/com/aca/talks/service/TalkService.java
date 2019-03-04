package com.aca.talks.service;

import com.aca.talks.domain.Rating;
import com.aca.talks.domain.Talk;

import java.util.List;

public interface TalkService {
    List<Talk> findAll();
    Talk findById(Long id);
    Talk save(Talk talk);
    void delete(Talk talk);
    Long calculateRating(Talk talk);
}
