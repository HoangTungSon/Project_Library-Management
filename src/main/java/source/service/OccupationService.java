package source.service;

import source.model.borrower.Occupation;

public interface OccupationService {

    Iterable<Occupation> findAll();

    Occupation findById(Long id);

    void save (Occupation occupation);

    void delete (Long id);


}
