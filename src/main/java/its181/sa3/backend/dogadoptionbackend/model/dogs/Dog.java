package its181.sa3.backend.dogadoptionbackend.model.dogs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import its181.sa3.backend.dogadoptionbackend.model.users.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private int age;
    private String description;
    private boolean adopted;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "adopter_id")
    @JsonIgnoreProperties({"password", "adoptedDogs"})
    private User adopter;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Dog() {}

    public Dog(String name, String breed, int age, String description, boolean adopted, String imageUrl) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.adopted = adopted;
        this.imageUrl = imageUrl;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isAdopted() { return adopted; }
    public void setAdopted(boolean adopted) { this.adopted = adopted; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public User getAdopter() { return adopter; }
    public void setAdopter(User adopter) { this.adopter = adopter; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
