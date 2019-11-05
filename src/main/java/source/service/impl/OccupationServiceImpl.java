package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Occupation;
import source.repository.OccupationRepository;
import source.service.OccupationService;

public class OccupationServiceImpl implements OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    @Override
    public Iterable<Occupation> findAll() {
        return occupationRepository.findAll();
    }

    @Override
    public Occupation findById(Long id) {
        return occupationRepository.findOne(id);
    }

    @Override
    public void save(Occupation occupation) {
        occupationRepository.save(occupation);
    }

    @Override
    public void delete(Long id) {
        occupationRepository.delete(id);
    }
}
