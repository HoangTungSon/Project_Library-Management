package source.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "occupations")
public class Occupation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToMany(mappedBy = "occupation")
    private Set<Borrower> borrowerSet;

    public Occupation() {
    }

    public Occupation(String type) {
        this.type = type;
    }

    public Occupation(String type, Set<Borrower> borrowerSet) {
        this.type = type;
        this.borrowerSet = borrowerSet;
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

    public Set<Borrower> getBorrowerSet() {
        return borrowerSet;
    }

    public void setBorrowerSet(Set<Borrower> borrowerSet) {
        this.borrowerSet = borrowerSet;
    }
}
