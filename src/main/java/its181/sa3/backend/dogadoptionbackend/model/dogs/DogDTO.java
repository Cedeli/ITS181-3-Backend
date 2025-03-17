package its181.sa3.backend.dogadoptionbackend.model.dogs;

public class DogDTO {
    private String name;
    private String breed;
    private String description;
    private String age;
    private String imageUrl;

    public DogDTO() {}

    public DogDTO(String name, String breed, String age, String description, String imageUrl) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed;}

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}

