package com.example.borrowbook.repository;

import com.example.borrowbook.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, String> {
}
