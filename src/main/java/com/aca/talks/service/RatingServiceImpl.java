package com.aca.talks.service;

import com.aca.talks.domain.Rating;
import com.aca.talks.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getById(Long id) {
        return ratingRepository.getOne(id);
    }

    @Override
    public void delete(Rating rating) {
        ratingRepository.delete(rating);

    }

    @Override
    public Rating save(Rating rating) {
        return  ratingRepository.save(rating);
    }

    @Override
    public Rating update(Rating rating) {
       return ratingRepository.save(rating);
    }
}
