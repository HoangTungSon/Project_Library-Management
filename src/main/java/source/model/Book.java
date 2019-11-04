package source.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String publisher;

    private String pub_date;

    @JsonIgnore
    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToOne
    private Book_condition book_condition;


    public Book() {
    }

    public Book(String title, String publisher, String pub_date) {
        this.title = title;
        this.publisher = publisher;
        this.pub_date = pub_date;
    }

    public Book(String title, String publisher, String pub_date, Category category, Book_condition book_condition) {
        this.title = title;
        this.publisher = publisher;
        this.pub_date = pub_date;
        this.category = category;
        this.book_condition = book_condition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book_condition getBook_condition() {
        return book_condition;
    }

    public void setBook_condition(Book_condition book_condition) {
        this.book_condition = book_condition;
    }
}
