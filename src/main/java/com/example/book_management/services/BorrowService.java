package com.example.book_management.services;

import com.example.book_management.models.dto.BorrowResponseDTO;
import com.example.book_management.models.entities.Book;
import com.example.book_management.models.entities.BorrowTicket;
import com.example.book_management.repositories.BookRepository;
import com.example.book_management.repositories.BorrowTicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowService {
    private BorrowTicketRepository borrowTicketRepository;
    private BookRepository bookRepository;

    @Transactional
    public BorrowResponseDTO borrowBook(long bookId, String studentName) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("404 - Không tìm thấy sách"));

        boolean isAlreadyBorrowed = borrowTicketRepository.existsByBookIdAndStatus(bookId, "BORROWED");
        if (isAlreadyBorrowed) {
            throw new RuntimeException("400 - Sách đã có người mượn");
        }

        BorrowTicket ticket = new BorrowTicket();
        ticket.setStudentName(studentName);
        ticket.setBook(book);
        ticket.setBorrowDate(LocalDate.now());
        ticket.setStatus("BORROWED");

        borrowTicketRepository.save(ticket);

        return new BorrowResponseDTO(
                ticket.getStudentName(),
                book.getTitle(),
                book.getAuthor().getName(),
                ticket.getBorrowDate()
        );
    }
}
