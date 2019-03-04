package com.aca.talks.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalkDto {
    private Long id;
    private String Name;
    private String Description;
    private String Url;
    private Long Rating;

}
