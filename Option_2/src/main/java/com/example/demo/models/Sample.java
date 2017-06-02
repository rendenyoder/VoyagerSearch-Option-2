package com.example.demo.models;

import com.fasterxml.jackson.databind.ObjectMapper;
public class Sample {
    private Integer id;
    private String author;
    private String title;
    private String text;
    private String fullText;

    public Sample(Integer id, String author, String title, String text, String fullText) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.fullText = fullText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String toJSON(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return ('[' + mapper.writeValueAsString(this) + ']');
        } catch (Exception e){
            return null;
        }
    }
}
