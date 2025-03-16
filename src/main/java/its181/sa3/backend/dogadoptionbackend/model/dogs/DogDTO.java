package its181.sa3.backend.dogadoptionbackend.model.dogs;

public class DogDTO {
    private String name;
    private String breed;
    private String description;
    private int age;

    public DogDTO() {}

    public DogDTO(String name, String breed, int age, String description) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed;}

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

