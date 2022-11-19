package com.example.borrowbook.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBorrow;
    private String borrowID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowBook() {
    }

    public BorrowBook(int idBorrow, String borrowID, Book book) {
        this.idBorrow = idBorrow;
        this.borrowID = borrowID;

        this.book = book;
    }

    public String getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(String borrowID) {
        this.borrowID = borrowID;
    }

    public int getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(int idBorrow) {
        this.idBorrow = idBorrow;
    }

}
