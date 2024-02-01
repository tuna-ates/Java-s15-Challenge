package com.workintech.books;

import com.workintech.person.Author;

public class Journals extends Book{
    public Journals(int id, Author author, String name, int price, Status status, BookType bookType) {
        super(id, author, name, price, status, BookType.JOURNAL);
    }

}
