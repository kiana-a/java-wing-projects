package run.wing.bookstore;

import run.wing.bookstore.controller.BookStore;
import run.wing.bookstore.model.Book;
import run.wing.bookstore.model.Print;

/**
 * Created by kiana on 10/12/17.
 */
public class Application {
    public static void main(String[] args) {
        BookStore bookStore = BookStore.getInstance();

//        bookStore.addBook(new Book("a" , "12",1200L,"s1"));
//        bookStore.addBook(new Book("b" , "22",10300L,"s2"));
//        bookStore.addBook(new Book("c" , "142",10200L,"s1"));
//        bookStore.addBook(new Book("d" , "125",10030L,"s1"));
//        bookStore.addBook(new Book("e" , "126",10002L,"e1"));
//        bookStore.addBook(new Book("q" , "124",1008L,"s1"));
//        bookStore.addBook(new Book("p" , "132",100L,"s1"));
//        bookStore.addBook(new Book("h" , "123",190L,"s1"));
//        bookStore.addBook(new Book("h" , "123",70090L,"s1"));
//        bookStore.addBook(new Book("h" , "123",50090L,"s1"));
//        bookStore.addBook(new Book("h" , "123",60090L,"s1"));

//        bookStore.saveToFile();
//
//

        bookStore.loadFromFile();
        bookStore.print(Print.CHEAP);
        System.out.println();
        bookStore.print(Print.EXPENSIVE);
        System.out.println();
        bookStore.print(Print.SUBJECTS);



        bookStore.deleteBook("126");

        System.out.println("******************");

        bookStore.print(Print.CHEAP);
        System.out.println();
        bookStore.print(Print.EXPENSIVE);
        System.out.println();
        bookStore.print(Print.SUBJECTS);

    }
}
