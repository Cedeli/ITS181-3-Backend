package its181.sa3.backend.dogadoptionbackend.model.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogDAO {

    private final DogRepo repository;

    @Autowired
    public DogDAO(DogRepo repository) {
        this.repository = repository;
    }

    public void save(Dog dog) {
        repository.save(dog);
    }

    public List<Dog> getAllDogs() {
        return repository.findAll();
    }

    public void delete(Dog dog) {
        repository.delete(dog);
    }
}
