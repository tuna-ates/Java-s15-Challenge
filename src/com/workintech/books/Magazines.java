package com.workintech.books;

import com.workintech.person.Author;

public class Magazines extends Book{
    public Magazines(int id, Author author, String name, int price, Status status, BookType bookType) {
        super(id, author, name, price, status, BookType.MAGAZİNE);
    }


}
