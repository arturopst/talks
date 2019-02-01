package com.aca.talks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long UserId;
    private Long Rating;



}
