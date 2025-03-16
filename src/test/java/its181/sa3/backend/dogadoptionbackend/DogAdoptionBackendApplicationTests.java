package its181.sa3.backend.dogadoptionbackend;

import its181.sa3.backend.dogadoptionbackend.model.dogs.Dog;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogDTO;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogRepository;
import its181.sa3.backend.dogadoptionbackend.services.DogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enable Mockito JUnit 5 support
class DogAdoptionBackendApplicationTests {

	@Mock
	private DogRepository dogRepository;

	@InjectMocks
	private DogService dogService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddDog() {
		DogDTO dogDTO = new DogDTO();
		dogDTO.setName("Buddy");
		dogDTO.setAge(3);
		dogDTO.setTemperament("Friendly");

		Dog dog = new Dog();
		dog.setId(1L);
		dog.setName(dogDTO.getName());
		dog.setAge(dogDTO.getAge());
		dog.setTemperament(dogDTO.getTemperament());

		when(dogRepository.save(any(Dog.class))).thenReturn(dog);

		Dog savedDog = dogService.addDog(dogDTO);
		assertNotNull(savedDog);
		assertEquals(1L, savedDog.getId());
		assertEquals("Buddy", savedDog.getName());
		assertEquals(3, savedDog.getAge());
		assertEquals("Friendly", savedDog.getTemperament());
	}

	@Test
	void testGetAllDogs() {
		Dog dog1 = new Dog(1L, "Charlie", 2, "Calm");
		Dog dog2 = new Dog(2L, "Max", 4, "Playful");

		when(dogRepository.findAll()).thenReturn(Arrays.asList(dog1, dog2));

		List<Dog> dogs = dogService.getAllDogs();
		assertEquals(2, dogs.size());
		assertEquals("Charlie", dogs.getFirst().getName());
		assertEquals(2, dogs.get(0).getAge());
		assertEquals("Calm", dogs.get(0).getTemperament());

		assertEquals("Max", dogs.get(1).getName());
		assertEquals(4, dogs.get(1).getAge());
		assertEquals("Playful", dogs.get(1).getTemperament());
	}

	@Test
	void testGetDogById() {
		Dog dog = new Dog(1L, "Rocky", 3, "Energetic");

		when(dogRepository.findById(1L)).thenReturn(Optional.of(dog));

		Optional<Dog> foundDog = dogService.getDogById(1L);
		assertTrue(foundDog.isPresent());
		assertEquals("Rocky", foundDog.get().getName());
		assertEquals(3, foundDog.get().getAge());
		assertEquals("Energetic", foundDog.get().getTemperament());
	}

	@Test
	void testDeleteDog() {
		Long dogId = 1L;
		doNothing().when(dogRepository).deleteById(dogId);

		dogService.deleteDog(dogId);
		verify(dogRepository, times(1)).deleteById(dogId);
	}
}
