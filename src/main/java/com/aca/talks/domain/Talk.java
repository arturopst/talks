package com.aca.talks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Description;
    private String Url;

    @OneToMany
    List<Rating> ratings = new ArrayList<Rating>();
    @ManyToOne
    User user ;

}
