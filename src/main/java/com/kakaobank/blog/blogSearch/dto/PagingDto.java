package com.kakaobank.blog.blogSearch.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PagingDto {

   private Integer totalCount;
   private Integer pageableCount;
   private Boolean isEnd;
   private Integer currentPage;
   private Integer totalPage;



   @Builder
    public PagingDto(Integer totalCount, Integer pageableCount, Boolean isEnd, Integer currentPage, Integer totalPage) {
        this.totalCount = totalCount;
        this.pageableCount = pageableCount;
        this.isEnd = isEnd;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
    }
}
