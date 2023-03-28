package com.kakaobank.blog.blogSearch.controller;

import com.kakaobank.blog.blogSearch.dto.PostSearchRequestDto;
import com.kakaobank.blog.blogSearch.service.SearchService;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/blog/searchList")
    public Map<String,Object> searchPost(@RequestBody PostSearchRequestDto postSearchRequestDto) {


        if(StringUtils.isNullOrEmpty(postSearchRequestDto.getQuery())){
            throw new RuntimeException();
        }

        return searchService.searchPost(postSearchRequestDto);

    }




}
