package com.workintech.person;

import com.workintech.books.Book;

import java.util.Set;

public class Author extends Person{
    private Set<Book> books;


    public Author(String name, int position ) {
        super(name, position);

    }
    public Author(String name, int position, Set<Book> books) {
        super(name, position);
        this.books=books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Author=" + super.getName() +
                " books="+books+
                "} " + super.toString();
    }
}
