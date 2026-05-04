package com.example.book_management.repositories;

import com.example.book_management.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();

    @Query("SELECT b FROM Book b WHERE b.id = :id")
    List<Book> findBookById(@Param("id") Long id);

    //Query Method: Viết hàm tìm sách theo tiêu đề có chứa từ khóa (findByTitleContaining).
    List<Book> findByTitleContainingIgnoreCase(String keyword);

    //@Query (JPQL): Viết truy vấn lấy tất cả sách có giá cao hơn mức trung bình.
    @Query("SELECT b FROM Book b WHERE b.price > (SELECT AVG(b2.price) FROM Book b2)")
    List<Book> findBooksAboveAveragePrice();

    //@Query (Native SQL): Viết câu lệnh SQL thuần để thống kê mỗi tác giả có bao nhiêu cuốn sách.
    @Query(value = "SELECT a.name AS authorName, COUNT(b.id) AS bookCount " +
            "FROM authors a LEFT JOIN books b ON a.id = b.author_id " +
            "GROUP BY a.id, a.name", nativeQuery = true)
    List<Map<String, Object>> countBooksByAuthor();
}
