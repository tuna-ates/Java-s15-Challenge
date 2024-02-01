import com.workintech.books.*;
import com.workintech.library.Library;
import com.workintech.person.Author;
import com.workintech.person.Reader;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Author tuna=new Author("tuna",1);
        Author ahmet=new Author("ahmet",1);
        Author buse=new Author("buse",1);

        Reader reader1=new Reader("Kullanıcı1",0);
        Reader reader2=new Reader("Kullanıcı2",0);

        Book magazineBook=new Magazines(1,tuna,
                "spor",125,Status.IDLE, BookType.MAGAZİNE);

        Book magazineBook2=new Magazines(2,ahmet,
                "siyaset",125,Status.IDLE, BookType.MAGAZİNE);

        Book studyBook=new StudyBooks(2,buse,
                "matematik",135,Status.IDLE, BookType.STUDY);

        Book journalBook=new Journals(3,buse,
                "spor",125,Status.IDLE, BookType.JOURNAL);




        List<Book> books =new ArrayList<>();
        books.add(magazineBook);
        books.add(studyBook);

        Set<Reader> readers=new HashSet<>();
        readers.add(reader1);
        readers.add(reader2);

        Library library=new Library(books,readers);
        System.out.println(library.getBooks());
        System.out.println(library.getReaders());


        System.out.println("--------------------------------");
        System.out.println("********YENİ KİTAP EKLEME********");
        library.addBook(journalBook);
        System.out.println(library.getBooks());

        System.out.println("--------------------------------");
        System.out.println("********ID,ISIM,YAZARA GÖRE KİTAP GETİRME********");
        System.out.println("-------------id'ye göre---------------");
        library.selectBookId(2);
        System.out.println("--------------isime göre---------------");
        library.selectBookName("spor");
        System.out.println("------------yazara göre--------------");
        library.selectBookAuthor("buse");

        System.out.println("--------------------------------");
        System.out.println("********KİTAP GÜNCELLEME********");
        library.updateBook(magazineBook,magazineBook2);

        System.out.println("--------------------------------");
        System.out.println("********KİTAP SİLME********");
        library.deleteBook(studyBook);

        System.out.println("--------------------------------");
        System.out.println("********BÜTÜN KİTAPLARI SİLME********");
        library.allDeleteBook();

        System.out.println("--------------------------------");
        library.addBook(magazineBook);
        library.addBook(magazineBook2);
        library.addBook(studyBook);
        library.addBook(journalBook);

        System.out.println("--------------------------------");
        System.out.println("********KATEGORİYE GÖRE KİTAP GETİRME********");
        library.selectCategoryWithBook(BookType.MAGAZİNE);

        System.out.println("--------------------------------");
        System.out.println("********VAR OLAN YAZARA GÖRE KİTAP GETİRME********");
        library.authorBooks(new Author("buse",1));

        System.out.println("--------------------------------");
        System.out.println("********KİTAP ÖDÜNÇ ALMA********");
        library.borrowBook(reader1,magazineBook);


        System.out.println("--------------------------------");
        System.out.println("********KİTAP GERİ TESLİM ETME********");
        library.deliveryBook(reader1);

    }
}