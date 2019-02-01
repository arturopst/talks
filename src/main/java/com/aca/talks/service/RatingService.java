package com.aca.talks.service;

import com.aca.talks.domain.Rating;

import java.util.List;

public interface RatingService  {
    public List<Rating> getAll();
    public Rating getById(Long id);
    public void delete(Rating rating);
    public Rating save(Rating rating);
    public Rating update(Rating rating);
}
