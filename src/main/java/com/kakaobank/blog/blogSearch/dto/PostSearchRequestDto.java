package com.kakaobank.blog.blogSearch.dto;

import lombok.Builder;
import lombok.Getter;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Getter
public class PostSearchRequestDto {

    private String query;
    private String sort;// accuracy & recency
    private Integer page; // 1~50 기본값 1
    private Integer size; // 1~50 기본값 10

    @Builder
    public PostSearchRequestDto(String query, String sort, Integer page, Integer size) {
        this.query = query;
        this.sort = StringUtils.isNullOrEmpty(sort) ? "accuracy" : sort;
        this.page = page==null ? 1 : page;
        this.size = size==null ? 10 : size;
    }
}
