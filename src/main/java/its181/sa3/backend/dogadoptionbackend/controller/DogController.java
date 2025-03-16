package its181.sa3.backend.dogadoptionbackend.controller;

import its181.sa3.backend.dogadoptionbackend.model.dogs.Dog;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogDTO;
import its181.sa3.backend.dogadoptionbackend.services.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs(
            @RequestParam(required = false) Boolean adopted) {
        if (adopted != null) {
            return ResponseEntity.ok(dogService.getDogsByAdoptionStatus(adopted));
        }
        return ResponseEntity.ok(dogService.getAllDogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        return dogService.getDogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dog> addDog(@RequestBody @Validated DogDTO dogDTO) {
        Dog dog = dogService.addDog(dogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(
            @PathVariable Long id,
            @RequestBody @Validated DogDTO dogDTO) {
        return dogService.updateDog(id, dogDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/adopt")
    public ResponseEntity<Dog> adoptDog(
            @PathVariable Long id,
            @RequestParam Long userId) {
        return dogService.adoptDog(id, userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        if (dogService.deleteDog(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
