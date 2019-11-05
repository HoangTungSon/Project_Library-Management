package source.service;

import source.model.borrower.Borrower;

public interface BorrowerService {
    Iterable<Borrower> findAll();

    Borrower findById(Long id);

    void save (Borrower borrower);

    void delete (Long id);

    Iterable<Borrower> findAllByOccupation_Type(String occupation_type);

    Borrower findAllByNationalId(Long nationalId);}
