package com.workintech.person;

import com.workintech.books.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reader extends Person{
    List<Book> books;
    private int claimBook;
    private int bill;



    public Reader(String name, int position) {
        super(name, position);
        this.books=new ArrayList<>();
        this.claimBook=0;
        this.bill=0;
    }


    public int getClaimBook() {
        return claimBook;
    }

    public void setClaimBook(int claimBook) {
        this.claimBook = claimBook;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
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
