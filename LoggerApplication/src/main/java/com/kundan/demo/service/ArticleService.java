package com.kundan.demo.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kundan.demo.model.Article;



@Service
public class ArticleService {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
    public List<Article> getArticles(){
        logger.debug("inside getArticles() method");
        return Arrays.asList(new Article(100, "article1"),new Article(200, "article2"));
    }

}
