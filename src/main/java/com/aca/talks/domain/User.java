package com.aca.talks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private List<Talk> talkList = new ArrayList<>();

    @OneToMany
    private List<Rating> rates = new ArrayList<>();

}
