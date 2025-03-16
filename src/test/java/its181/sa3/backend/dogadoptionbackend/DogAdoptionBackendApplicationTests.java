package its181.sa3.backend.dogadoptionbackend;

import its181.sa3.backend.dogadoptionbackend.model.dogs.Dog;
import its181.sa3.backend.dogadoptionbackend.model.dogs.DogDAO;
import its181.sa3.backend.dogadoptionbackend.model.users.User;
import its181.sa3.backend.dogadoptionbackend.model.users.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DogAdoptionBackendApplicationTests {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private DogDAO dogDAO;

	@Test
	void addUserTest() {
		User user = new User();
		user.setEmail("gian@gmail.com");
		userDAO.save(user);
	}

	@Test
	void addDogTest() {
		Dog dog = new Dog();
		dog.setName("robert");
		dogDAO.save(dog);
	}

	@Test
	void contextLoads() {
	}

}
