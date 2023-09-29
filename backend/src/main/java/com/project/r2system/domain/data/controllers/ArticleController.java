package com.project.r2system.domain.data.controllers;


import com.project.r2system.domain.data.entities.Article;
import com.project.r2system.domain.data.entities.Measure;
import com.project.r2system.domain.data.payloads.ArticleResponse;
import com.project.r2system.domain.data.services.ArticleService;
import com.project.r2system.domain.data.services.CategoryService;
import com.project.r2system.domain.data.services.MeasureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/data/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MeasureService measureService;

    @GetMapping("/all")
    public ResponseEntity<List<ArticleResponse>> getAllArticles()
    {
        List<Article> articles = articleService.allArticles();
        if (articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<ArticleResponse> DTO = new ArrayList<>();
        for (Article article : articles) {
            DTO.add(new ArticleResponse(article));
        }
        return new ResponseEntity<>(DTO, HttpStatus.OK);
    }

    @GetMapping("/{idN}")
    public ResponseEntity<Article> getArticleById(@PathVariable Integer idN) {
        Article article = articleService.ArticleById(idN);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        String state = articleService.createArticle(article);
        if(state != "OK"){
            return new ResponseEntity<String>(state, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    /*
    @PutMapping("/{idN}")
    public ResponseEntity<?> updateArticle(@PathVariable Integer idN, @RequestBody ArticleResponse updatedArticle) {
        try {
            String createdArticle = articleService.updateArticle(idN,updatedArticle);
            if(createdArticle == "NOT_FOUND"){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(createdArticle, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}