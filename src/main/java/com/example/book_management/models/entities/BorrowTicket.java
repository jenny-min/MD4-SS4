package com.example.book_management.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_tickets")
public class BorrowTicket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String studentName;
    private LocalDate borrowDate;
    private String status; // "BORROWED" hoặc "RETURNED"
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowTicket() {
    }

    public BorrowTicket(long id, String studentName, LocalDate borrowDate, String status, Book book) {
        this.id = id;
        this.studentName = studentName;
        this.borrowDate = borrowDate;
        this.status = status;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
