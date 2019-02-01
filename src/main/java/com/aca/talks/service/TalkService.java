package com.aca.talks.service;

import com.aca.talks.domain.Rating;
import com.aca.talks.domain.Talk;

import java.util.List;

public interface TalkService {
    public List<Talk> findAll();
    public List<Talk> findByUserId(Long id);
    public Talk findById(Long id);
    public Talk save(Talk talk);
    public void delete(Talk talk);
    public Talk updateTalk(Talk talk);
}
