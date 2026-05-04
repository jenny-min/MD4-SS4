package com.example.book_management.repositories;

import com.example.book_management.models.entities.BorrowTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowTicketRepository extends JpaRepository<BorrowTicket,Long> {
    @Query("select count(bt.id) > 0 from BorrowTicket bt where bt.book.id = :bookId and bt.status = :status")
    boolean existsByBookIdAndStatus(@Param("bookId") long bookId, @Param("status") String status);
}
