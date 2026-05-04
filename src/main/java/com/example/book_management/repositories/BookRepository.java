package com.example.book_management.repositories;

import com.example.book_management.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();

    @Query("SELECT b FROM Book b WHERE b.id = :id")
    List<Book> findBookById(@Param("id") Long id);
}
