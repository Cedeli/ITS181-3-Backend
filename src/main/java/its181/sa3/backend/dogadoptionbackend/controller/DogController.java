package its181.sa3.backend.dogadoptionbackend.controller;

import its181.sa3.backend.dogadoptionbackend.model.dogs.Dog;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogDTO;
import its181.sa3.backend.dogadoptionbackend.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dogs") // apparently better than GetMapping???
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        return ResponseEntity.ok(dogService.getAllDogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        Optional<Dog> dog = dogService.getDogById(id);
        return dog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dog> addDog(@RequestBody DogDTO dogDTO) {
        return ResponseEntity.ok(dogService.addDog(dogDTO));
    }

    @PutMapping("/{id}/adopt")
    public ResponseEntity<Dog> adoptDog(@PathVariable Long id) {
        Dog adoptedDog = dogService.adoptDog(id);
        return adoptedDog != null ? ResponseEntity.ok(adoptedDog) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }
}
