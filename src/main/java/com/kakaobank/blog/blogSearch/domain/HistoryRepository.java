package com.kakaobank.blog.blogSearch.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface HistoryRepository extends JpaRepository<History,Long> {

    Optional<History> findByKeyword(String keyword);

    List<History> findTop10ByOrderByCountDesc();
}
