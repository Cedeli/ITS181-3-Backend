package its181.sa3.backend.dogadoptionbackend.model.dogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// using JPA, change if cringe
public interface DogRepository extends JpaRepository<Dog, Long> {

}
