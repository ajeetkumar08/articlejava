package com.ajeet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.ajeet.model.Article;
import com.ajeet.repository.ArticleRepository;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "articles", description = "Article controller")
public class ArticleController {

	final private ArticleRepository articleRepository;

	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Operation(summary = "Find all article", description = "All article", tags = { "article" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Article.class)))) })
	@GetMapping("/articles")
	public List<Article> index() {
		return articleRepository.findAll();
	}
	
	@Operation(summary = "Create a new article", description = "Create a new article", tags = { "article" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Article.class))) })
	@PostMapping("/articles")
	public Article create(@RequestBody Map<String, String> craeteAuthor) {
		String title = craeteAuthor.get("title");
		String body = craeteAuthor.get("body");
		String author = craeteAuthor.get("author");
		return articleRepository.save(new Article(title, body, author));
	}

	@Operation(summary = "Find article by id", description = "Find article by id", tags = { "article" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Article.class))) })
	@GetMapping("/articles/{id}")
	public Article show(@PathVariable String id) {
		int articleId = Integer.parseInt(id);
		return articleRepository.findById(articleId).orElse(new Article());
	}

	@Operation(summary = "Update a new article", description = "Update a new article", tags = { "article" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Article.class))) })
	@PutMapping("/articles/{id}")
	public Article update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int articleId = Integer.parseInt(id);
		// getting Article
		Article article = articleRepository.findById(articleId).orElse(new Article());
		article.setTitle(body.get("title"));
		article.setbody(body.get("boby"));
		article.setAuthor(body.get("author"));
		return articleRepository.save(article);
	}

	@Operation(summary = "Delete a  article", description = "Delete a article", tags = { "article" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Boolean.class))) })
	@DeleteMapping("/articles/{id}")
	public boolean delete(@PathVariable String id) {
		int articleId = Integer.parseInt(id);
		articleRepository.deleteById(articleId);
		return true;
	}

}
