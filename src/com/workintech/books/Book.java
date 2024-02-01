package com.workintech.books;

import com.workintech.person.Author;

public class Book {
    private  int id;
    private Author author;
    private String name;
    private int price;
    private Status status;
    private BookType bookType;

    public Book(int id, Author author, String name,
                int price, Status status, BookType bookType) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.bookType = bookType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", bookType=" + bookType +
                '}';
    }
}
