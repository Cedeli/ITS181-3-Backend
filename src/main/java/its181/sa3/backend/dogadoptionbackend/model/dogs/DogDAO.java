package its181.sa3.backend.dogadoptionbackend.model.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogDAO {

    @Autowired
    private DogRepo repository;

    public void save(Dog dog) {
        repository.save(dog);
    }

    public List<Dog> getAllDogs() {
        List<Dog> dogs = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(dogs::add);
        return dogs;
    }

    public void delete(Dog dog) {
        repository.delete(dog);
    }

}
