package run.wing.bookstore.view;

import run.wing.bookstore.model.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by kiana on 10/12/17.
 */
public class BookView {
    public void printBook(Book book) {
        System.out.println(book.getName() + " " + book.getIsbn() + " " + book.getCost());
    }

    public void printBooks(List<Book> books) {
        for (Book book : books)
            this.printBook(book);
    }

    public void printSubjects(Set<String> subjects) {
        for (String s : subjects) {
            System.out.println(s);
        }

    }

}
