package com.ajeet.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ajeet.model.Aricle;
import com.ajeet.service.AricleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AricleQuery implements GraphQLQueryResolver {

    @Autowired
    private AricleService aricleService;

    public List<Aricle> getAricles(final int count){
        return this.aricleService.getAllAricles(count);
    }

    public Optional<Aricle> getAricle(final int id){return this.aricleService.getAricle(id);}

}
