package com.kakaobank.blog.blogSearch.service;

import com.kakaobank.blog.blogSearch.dto.PagingDto;
import com.kakaobank.blog.blogSearch.dto.PostSearchRequestDto;
import com.kakaobank.blog.blogSearch.dto.PostSearchResponseDto;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    @Value("${kakao.url}")
    private String apiUrl;

   @Value("${kakao.rest-api-key}")
    private String restApiKey;

    private RestTemplate restTemplate = new RestTemplate();

    public  Map<String,Object> searchPost(@RequestBody PostSearchRequestDto postSearchRequestDto) {

        Map<String,Object> searchResult = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.AUTHORIZATION, "KakaoAK " + restApiKey );

        HttpEntity<?> request = new HttpEntity<>(headers);

        String restApiUrl = apiUrl + "/v2/search/blog?query=" +postSearchRequestDto.getQuery()
                + "&sort=" + postSearchRequestDto.getSort()
                +"&page=" +postSearchRequestDto.getPage()
                + "&size=" + postSearchRequestDto.getSize();

        ResponseEntity<Map> response = restTemplate.exchange(restApiUrl, HttpMethod.GET, request, Map.class);

        if(!response.getStatusCode().equals(HttpStatus.OK)){
            throw new RuntimeException();
        }

        Map<String,Object> pageMeta = (Map) response.getBody().get("meta");
        Integer totalpage = (Integer)pageMeta.get("pageable_count")%postSearchRequestDto.getSize()==0?
                (Integer)pageMeta.get("pageable_count")/postSearchRequestDto.getSize() :
                (Integer)pageMeta.get("pageable_count")/postSearchRequestDto.getSize() +1;

        PagingDto paging = PagingDto.builder()
                .totalCount((Integer) pageMeta.get("total_count"))
                .isEnd((Boolean) pageMeta.get("is_end"))
                .pageableCount((Integer) pageMeta.get("pageable_count"))
                .totalPage(totalpage)
                .currentPage(postSearchRequestDto.getPage())
                .build();

        List<PostSearchResponseDto> postsList = (ArrayList) response.getBody().get("documents");

        searchResult.put("paging", paging);
        searchResult.put("postsList",postsList);

        return searchResult;
    }

}
