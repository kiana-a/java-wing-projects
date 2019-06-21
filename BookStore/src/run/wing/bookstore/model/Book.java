package run.wing.bookstore.model;

/**
 * Created by kiana on 10/12/17.
 */
public class Book {
    private String name;
    private String isbn;
    private String author;
    private Long cost;
    private String subject;
    private Publisher publisher;

    public Book(String name, String isbn, Long cost, String subject) {
        this.name = name;
        this.isbn = isbn;
        this.cost = cost;
        this.subject = subject;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public  String getIsbn(){
        return this.isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}

