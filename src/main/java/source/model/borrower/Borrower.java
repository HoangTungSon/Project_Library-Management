package source.model.borrower;

import com.fasterxml.jackson.annotation.JsonIgnore;
import source.model.Book_Borrower;
import source.model.book.Book;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrowers")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long nationalId;

    private String name;

    private Long jobId;

    @OneToMany(mappedBy = "borrower_id")
    private Set<Book_Borrower> book_borrower;

    @JsonIgnore
    @ManyToOne
    private Occupation occupation;


    public Borrower() {
    }

    public Borrower(Long nationalId, String name, Occupation occupation) {
        this.nationalId = nationalId;
        this.name = name;
        this.occupation = occupation;
    }

    public Borrower(Long nationalId, String name, Long jobId, Occupation occupation, Set<Book> bookSet) {
        this.nationalId = nationalId;
        this.name = name;
        this.jobId = jobId;
        this.occupation = occupation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobId() {
        return jobId;
    }
}
