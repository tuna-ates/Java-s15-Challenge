package com.workintech;

import com.workintech.books.Book;
import com.workintech.person.Reader;

public interface LibraryInterfaces {

    public void borrowBook(Reader reader,Book book);


    public void deliveryBook(Reader reader);


}
