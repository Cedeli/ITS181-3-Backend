package its181.sa3.backend.dogadoptionbackend.model.dogs;

public class DogDTO {
    private String name;
    private String breed;
    private int age;

    public DogDTO() {}

    public DogDTO(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() { return name; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }

    public void setName(String buddy) {
    }

    public void setAge(int i) {
    }

    public void setTemperament(String friendly) {
    }

    public Object getTemperament() {
        return null;
    }
}
