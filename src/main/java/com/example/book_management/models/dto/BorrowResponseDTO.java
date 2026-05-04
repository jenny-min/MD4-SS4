package com.example.book_management.models.dto;

import java.time.LocalDate;

public class BorrowResponseDTO {
    private String studentName;
    private String bookTitle;
    private String authorName;
    private LocalDate borrowDate;

    public BorrowResponseDTO() {
    }

    public BorrowResponseDTO(String studentName, String bookTitle, String authorName, LocalDate borrowDate) {
        this.studentName = studentName;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.borrowDate = borrowDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}
