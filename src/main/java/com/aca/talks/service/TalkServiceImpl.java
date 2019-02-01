package com.aca.talks.service;

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
}
