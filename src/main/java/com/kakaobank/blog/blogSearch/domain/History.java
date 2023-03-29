package com.kakaobank.blog.blogSearch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String keyword;

    @Column
    private Integer count;

    public void plusCount(Integer count){
        this.count = count+1;
    }

    @Builder
    public History(String keyword, Integer count) {
        this.keyword = keyword;
        this.count = count;
    }
}
