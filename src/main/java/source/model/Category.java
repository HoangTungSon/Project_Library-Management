package source.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Book> bookSet;

    public Category() {
    }

    public Category(String type) {
        this.type = type;
    }

    public Category(String type, Set<Book> bookSet) {
        this.type = type;
        this.bookSet = bookSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
