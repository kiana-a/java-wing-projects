package run.wing.bookstore.controller;

import com.google.gson.Gson;
import run.wing.bookstore.model.Book;
import run.wing.bookstore.model.Print;
import run.wing.bookstore.view.BookView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by kiana on 10/12/17.
 */
public class BookStore {

    private List<Book> bookList = new ArrayList<>();
    private BookView bookView = new BookView();
    private final String bookFile = "bookFile.json" ;

    private static BookStore ourInstance = new BookStore();

    public static BookStore getInstance() {
        return ourInstance;
    }

    private BookStore() {
    }

    public void deleteBook(String isbn) {
        for (Book book : bookList){
            if (book.getIsbn().equals(isbn)){
                bookList.remove(book);
                break;
            }
        }
    }
    public void addBook(Book book){
        bookList.add(book);
    }
    public List<Book> getTop10ExpensiveBooks (){

        List<Book> response = new ArrayList<>();

        TreeMap<Long, Book> bookTreeMap = new TreeMap<>();

        for(Book book : bookList) {
            bookTreeMap.put(book.getCost(), book);
            if (bookTreeMap.size() > 10)
                bookTreeMap.remove(bookTreeMap.firstKey());


        }

        for (Map.Entry<Long, Book> entry : bookTreeMap.entrySet())
            response.add(entry.getValue());


        return response;
    }
    public List<Book> getTop10CheapBooks () {
        bookList.sort(Comparator.comparing(Book::getCost));

        return bookList.subList(0, bookList.size() > 10 ? 10 : bookList.size());
    }

    public Set<String> getSubjects (){
        Set<String> subjects = new HashSet<>();
        for (Book book : bookList)
            subjects.add(book.getSubject());
        return subjects;
    }
    public void saveToFile(){

        try{

            PrintWriter printWriter = new PrintWriter(bookFile);
            printWriter.write(new Gson().toJson(this.bookList));
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        File file = new File(bookFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext()){
            String s = scanner.nextLine();
            Book[] books = new Gson().fromJson(s,Book[].class);
            this.bookList = new ArrayList<>();
            for (Book book: books) {
                this.bookList.add(book);
            }
        }
    }


    public void print(Print p){
        switch (p){
            case CHEAP:
                bookView.printBooks(this.getTop10CheapBooks());
                break;
            case SUBJECTS:
                bookView.printSubjects(this.getSubjects());
                break;
            case EXPENSIVE:
                bookView.printBooks(this.getTop10ExpensiveBooks());
                break;
            default:

        }
    }
}
