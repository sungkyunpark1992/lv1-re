package com.sparta.lv1restart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String contents;
    private String author;
    private String password;
}
