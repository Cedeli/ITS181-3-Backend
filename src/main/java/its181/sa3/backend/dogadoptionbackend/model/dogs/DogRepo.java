package its181.sa3.backend.dogadoptionbackend.model.dogs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends CrudRepository<Dog, Integer> {

}
