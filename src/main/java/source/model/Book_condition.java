package source.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "conditions")
public class Book_condition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    @OneToMany(mappedBy = "book_condition", fetch = FetchType.EAGER)
    private Set<Book> bookSet;

    public Book_condition(){}

    public Book_condition(String status) {
        this.status = status;
    }

    public Book_condition(String status, Set<Book> bookSet) {
        this.status = status;
        this.bookSet = bookSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
