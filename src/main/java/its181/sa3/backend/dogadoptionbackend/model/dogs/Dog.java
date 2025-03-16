package its181.sa3.backend.dogadoptionbackend.model.dogs;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;
    private String breed;
    private boolean adopted;


    // Constructors
    public Dog() {}

    public Dog(String name, String breed, int age, boolean adopted) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.adopted = adopted;
    }


    // alt insert my beloved
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public boolean isAdopted() { return adopted; }
    public void setAdopted(boolean adopted) { this.adopted = adopted; }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
