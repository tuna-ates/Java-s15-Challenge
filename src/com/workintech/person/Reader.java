package com.workintech.person;

import com.workintech.books.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reader extends Person{
    List<Book> books;

    public Reader(String name, int position) {
        super(name, position);
        this.books=new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name="+super.getName()+
                "} " + super.toString();
    }
}
