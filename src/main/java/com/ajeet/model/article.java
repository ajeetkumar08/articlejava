package com.ajeet.model;

import javax.persistence.*;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String body;
	private String author;

	public Article() {
	}

	public Article(String title, String body, String author) {
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public Article(int id, String title, String body, String author) {

		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getbody() {
		return body;
	}

	public void setbody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", body=" + body + ", author=" + author + "]";
	}

}
