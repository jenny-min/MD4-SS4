package com.example.book_management.controllers;

import com.example.book_management.models.dto.BookRequest;
import com.example.book_management.models.entities.Book;
import com.example.book_management.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if(book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookRequest));
    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<Book>> searchByTitle(String keyword) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.searchByTitle(keyword));
    }

    @GetMapping("/getBookHightPrice")
    public ResponseEntity<List<Book>> getBookHightPrice() {
        return ResponseEntity.ok(bookService.getPremiumBooks());
    }

    @GetMapping("/statisticsByAuthor")
    public ResponseEntity<List<Map<String, Object>>> statisticsByAuthor() {
        return ResponseEntity.ok(bookService.getAuthorStats());
    }
}
