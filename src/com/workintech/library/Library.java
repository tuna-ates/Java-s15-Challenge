package com.workintech.library;

import com.workintech.LibraryInterfaces;
import com.workintech.books.Book;
import com.workintech.books.BookType;
import com.workintech.books.Status;
import com.workintech.person.Person;
import com.workintech.person.Reader;

import java.util.*;

public class Library implements LibraryInterfaces {
    private List<Book> books;
    private Set<Reader> readers;
    private Map<Integer,Book> categoryBooks;
    private Map<Integer,Book> authorBooks;
    private List<Book> selectBooks;

    public Library(List<Book> books) {

        this.books = books;
        this.readers=new HashSet<>();
        this.categoryBooks=new HashMap<>();
        this.authorBooks=new HashMap<>();
        this.selectBooks=new ArrayList<>();
    }

    public Library(Set<Reader> readers) {
        this.readers = readers;
        this.categoryBooks=new HashMap<>();
        this.authorBooks=new HashMap<>();
        this.selectBooks=new ArrayList<>();
    }

    public Library(List<Book> books, Set<Reader> readers) {
        this.books = books;
        this.readers = readers;
        this.categoryBooks=new HashMap<>();
        this.authorBooks=new HashMap<>();
        this.selectBooks=new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    public Map<Integer, Book> getCategoryBooks() {
        return categoryBooks;
    }

    public void setCategoryBooks(Map<Integer, Book> categoryBooks) {
        this.categoryBooks = categoryBooks;
    }

    public Map<Integer, Book> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(Map<Integer, Book> authorBooks) {
        this.authorBooks = authorBooks;
    }

    public void addBook(Book book){
        if (book==null||book.getName()==null){
            System.out.println("Lütfen kitap objesini tam değerler ile giriniz!!");

        }
        this.books.add(book);
      System.out.println("Kitap eklendi: "+book);

  }

    public Book selectBookId(int id){
     Book result=new Book();
     for (int i=0;i<books.size();i++){
         if (books.get(i).getId()==id){
             System.out.println(books.get(i));
             return books.get(i);
         }
      }
      return  result;

  }

    public void selectBookName(String name){

        for (int i=0;i<books.size();i++){
            if (books.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(books.get(i));
            }
        }

    }
    public void selectBookAuthor(String authorname){

        for (int i=0;i<books.size();i++){
            if (books.get(i).getAuthor().getName().equalsIgnoreCase(authorname)){
                System.out.println(books.get(i));

            }
        }

    }


    public void updateBook(Book oldBook,Book newBook ){
         if (findBook(oldBook)<0){
             System.out.println("Bu kitap bulunamadı!!");
         }
        books.set(findBook(oldBook),newBook);
        System.out.println("Kitap başarılı bir şekilde güncellendi:"+books.get(findBook(newBook)));

    }

    public void deleteBook(Book book ){
        if (findBook(book)<0){
            System.out.println("Bu kitap bulunamadı!!");
        }
        books.remove(findBook(book));
        System.out.println("Kitap başarılı bir şekilde silindi!! "+book);

    }

    public void allDeleteBook( ){
         books.clear();
        System.out.println("Bütün kitaplar silindi: "+getBooks());

    }


    public void selectCategoryWithBook(BookType type){
        int index=0;
        if (type!=null){
            for (int i=0;i<books.size();i++){
                if (books.get(i).getBookType()==type){
                    categoryBooks.put(i,books.get(i));
                    index=index+1;
                }
            }
            System.out.println(type+" Tipindeki kitaplar: "+getCategoryBooks());
            categoryBooks.clear();
        }

    }

    public void authorBooks(Person author){
        int index=0;
        for (int i=0;i<books.size();i++){
            if(books.get(i).getAuthor().equals(author)){
                authorBooks.put(index,books.get(i));
                index=index+1;
            }

        }
        System.out.println(author.getName()+" Kişinin kitapları: "+getAuthorBooks());
        authorBooks.clear();
    }



    @Override
    public void borrowBook(Reader reader, Book book) {
        int claim=reader.getClaimBook();
        int bill=reader.getBill();
        if ( this.readers.contains(reader)&&reader.getClaimBook()<5){

            for (int i=0;i<books.size();i++){
                if (books.get(i).equals(book)&&books.get(i).getStatus()==Status.IDLE){
                    books.get(i).setStatus(Status.APPOINTED);
                    selectBooks.add(books.get(i));
                    reader.setBooks(selectBooks);
                    claim=claim+1;
                    reader.setClaimBook(claim);
                    bill=bill+books.get(i).getPrice();
                    reader.setBill(bill);
                    System.out.println(reader.getBooks());
                    System.out.println("Kesilen fatura tuturı:"+reader.getBill());
                }
            }

        }
        else {
            System.out.println("kullanıcı yok veya kitap alma hakkınız doludur");
        }
    }

    @Override
    public void deliveryBook(Reader reader) {
        int claim=reader.getClaimBook();
        int bill=reader.getBill();
        if ( this.readers.contains(reader)){

            for (int i=0;i<reader.getBooks().size();i++){

                if (books.contains(reader.getBooks().get(i))){
                    selectBookId(reader.getBooks().get(i).getId()).setStatus(Status.IDLE);
                    System.out.println("Geri teslim edilen kitap: "+reader.getBooks().get(i));

                    claim=claim-1;
                    reader.setClaimBook(claim);
                    bill=bill-reader.getBooks().get(i).getPrice();
                    System.out.println("Geri iade edilen tutar: "+reader.getBooks().get(i).getPrice());
                    reader.getBooks().remove(reader.getBooks().get(i));

                }
                else {
                    System.out.println("Bu kitap bulunamadı!!");
                }
            }

        }
        else {
            System.out.println("kullanıcı yok");
        }
    }






    public int findBook(Book book){

        return this.books.indexOf(book);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }




}
