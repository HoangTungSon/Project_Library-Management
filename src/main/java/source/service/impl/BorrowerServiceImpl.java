package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Borrower;
import source.repository.BorrowerRepository;
import source.service.BorrowerService;

public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public Iterable<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower findById(Long id) {
        return borrowerRepository.findOne(id);
    }

    @Override
    public void save(Borrower borrower) {
borrowerRepository.save(borrower);
    }

    @Override
    public void delete(Long id) {
borrowerRepository.delete(id);
    }

    @Override
    public Iterable<Borrower> findAllByOccupation_Type(String occupation_type) {
        return borrowerRepository.findAllByOccupation_Type(occupation_type);
    }

    @Override
    public Borrower findAllByNationalId(Long nationalId) {
        return borrowerRepository.findAllByNationalId(nationalId);
    }
}
