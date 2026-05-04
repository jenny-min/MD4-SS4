package com.example.book_management.services;

import com.example.book_management.models.dto.BookRequest;
import com.example.book_management.models.entities.Author;
import com.example.book_management.models.entities.Book;
import com.example.book_management.repositories.AuthorRepository;
import com.example.book_management.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> addBook(BookRequest bookRequest){
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElse(null);
        if(author == null){
            return new ResponseEntity<>("Tác giả không tồn tại", HttpStatus.BAD_REQUEST);
        } else {
            Book newBook = new Book();
            newBook.setAuthor(author);
            newBook.setTitle(bookRequest.getTitle());
            newBook.setPrice(bookRequest.getPrice());
            return new ResponseEntity<>(bookRepository.save(newBook), HttpStatus.CREATED);
        }
    }
}
