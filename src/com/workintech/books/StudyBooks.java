package com.workintech.books;

import com.workintech.person.Author;

public class StudyBooks extends Book{
    public StudyBooks(int id, Author author, String name, int price, Status status, BookType bookType) {
        super(id, author, name, price, status, BookType.STUDY);
    }
}
