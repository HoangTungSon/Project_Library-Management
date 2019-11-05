package source.service;

import source.model.Borrower;
import source.model.Occupation;

public interface OccupationService {

    Iterable<Occupation> findAll();

    Occupation findById(Long id);

    void save (Occupation occupation);

    void delete (Long id);


}
