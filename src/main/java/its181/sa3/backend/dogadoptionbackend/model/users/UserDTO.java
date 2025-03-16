package its181.sa3.backend.dogadoptionbackend.model.users;

public class UserDTO {
    private String email;
    private String password;
    private String role;

    public UserDTO() {}

    public UserDTO(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}