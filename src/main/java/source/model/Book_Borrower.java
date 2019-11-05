package source.model;

import source.model.book.Book;
import source.model.borrower.Borrower;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_borrower")
public class Book_Borrower implements Serializable {

    @Id
    @ManyToOne
    private Borrower borrower_id;

    @Id
    @ManyToOne
    private Book book_id;

    public Book_Borrower() {
    }

    public Book_Borrower(Borrower borrower_id, Book book_id) {
        this.borrower_id = borrower_id;
        this.book_id = book_id;
    }

    public Borrower getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(Borrower borrower_id) {
        this.borrower_id = borrower_id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }
}
