package com.ajeet.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajeet.model.Article;
import com.ajeet.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(final ArticleRepository articleRepository){this.articleRepository = articleRepository;}

    @Transactional(readOnly = true)
    public List<Article> getAllArticle(final int count){
        return this.articleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Article> getArticle(final int id){return this.articleRepository.findById(id);}
}
