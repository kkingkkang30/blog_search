package com.kakaobank.blog.blogSearch.controller;

import com.kakaobank.blog.blogSearch.domain.History;
import com.kakaobank.blog.blogSearch.dto.PostSearchRequestDto;
import com.kakaobank.blog.blogSearch.service.SearchService;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/searchList")
    public Map<String,Object> searchPost(@RequestBody PostSearchRequestDto postSearchRequestDto) {


        if(StringUtils.isNullOrEmpty(postSearchRequestDto.getQuery())){
            throw new RuntimeException();
        }

        return searchService.searchPost(postSearchRequestDto);

    }

    @GetMapping("/topKeyword")
    public List<History> topKeywordList(){
        return searchService.topKeywordList();
    }


}
