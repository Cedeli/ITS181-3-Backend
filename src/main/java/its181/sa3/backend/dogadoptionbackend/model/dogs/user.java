package its181.sa3.backend.dogadoptionbackend.model.dogs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class user {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String role;

}
