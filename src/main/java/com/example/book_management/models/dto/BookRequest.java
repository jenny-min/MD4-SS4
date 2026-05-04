package com.example.book_management.models.dto;

public class BookRequest {
    private long authorId;
    private String title;
    private double price;

    public BookRequest() {}

    public BookRequest(long authorId, String title, double price) {
        this.authorId = authorId;
        this.title = title;
        this.price = price;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
