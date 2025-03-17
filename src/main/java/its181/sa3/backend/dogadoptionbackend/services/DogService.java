package its181.sa3.backend.dogadoptionbackend.services;

import its181.sa3.backend.dogadoptionbackend.model.users.User;
import its181.sa3.backend.dogadoptionbackend.model.dogs.Dog;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogDTO;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogRepository;
import its181.sa3.backend.dogadoptionbackend.model.users.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    private final DogRepository dogRepository;
    private final UserRepository userRepository;

    public DogService(DogRepository dogRepository, UserRepository userRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
    }

    public Dog addDog(DogDTO dogDTO) {
        Dog dog = new Dog();
        dog.setName(dogDTO.getName());
        dog.setBreed(dogDTO.getBreed());
        dog.setAge(dogDTO.getAge());
        dog.setAdopted(false);
        return dogRepository.save(dog);
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public List<Dog> getDogsByAdoptionStatus(boolean adopted) {
        return dogRepository.findByAdopted(adopted);
    }

    public Optional<Dog> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    @Transactional
    public Optional<Dog> updateDog(Long id, DogDTO dogDTO) {
        return dogRepository.findById(id)
                .map(existingDog -> {
                    existingDog.setName(dogDTO.getName());
                    existingDog.setBreed(dogDTO.getBreed());
                    existingDog.setAge(dogDTO.getAge());
                    existingDog.setAdopted(dogDTO.getAdopted());
                    existingDog.setDescription(dogDTO.getDescription());
                    existingDog.setImageUrl(dogDTO.getImageUrl());
                    return dogRepository.save(existingDog);
                });
    }

    @Transactional
    public Optional<Dog> adoptDog(Long id, Long userId) {
        Optional<Dog> dogOptional = dogRepository.findById(id);
        if (dogOptional.isEmpty()) {
            return Optional.empty();
        }

        Dog dog = dogOptional.get();
        if (dog.getAdopted()) {
            throw new IllegalStateException("Dog is already adopted");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        dog.setAdopted(true);
        dog.setAdopter(user);
        return Optional.of(dogRepository.save(dog));
    }

    @Transactional
    public boolean deleteDog(Long id) {
        if (dogRepository.existsById(id)) {
            dogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}