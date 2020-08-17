package com.ajeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajeet.model.article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

}
