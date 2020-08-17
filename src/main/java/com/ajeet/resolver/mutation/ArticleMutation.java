package com.ajeet.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ajeet.model.Article;
import com.ajeet.model.mutation.CreateArticle;
import com.ajeet.repository.ArticleRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class ArticleMutation implements GraphQLMutationResolver {

    private ArticleRepository articleRepository;

    @Transactional
    public Article createArticle(CreateArticle body){
        String title = body.getTitle();
        String boby = body.getBody();
        String author = body.getAuthor();
        return articleRepository.save(new Article(title, boby, author));
    }


}
