package com.kakaobank.blog.blogSearch.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostSearchResponseDto {

    private String title;
    private String contents;
    private String url;
    private String blogName;
    private String thumbnail;
    private LocalDateTime dateTime;


    public PostSearchResponseDto(String title, String contents, String url, String blogName, String thumbnail, LocalDateTime dateTime) {
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.blogName = blogName;
        this.thumbnail = thumbnail;
        this.dateTime = dateTime;
    }
}
