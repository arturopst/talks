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

    @OneToMany(mappedBy = "talk", cascade=CascadeType.ALL )
    List<Rating> ratings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user ;

}
