package com.aca.talks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Talk {
    @Id
    //GeneratedValue()
    private Long id;
    private String Name;
    private String Description;
    private String Url;

}
