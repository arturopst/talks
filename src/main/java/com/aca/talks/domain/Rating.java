package com.aca.talks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long Rating;

    @ManyToOne
    User user;
    @ManyToOne
    Talk talk;
}
