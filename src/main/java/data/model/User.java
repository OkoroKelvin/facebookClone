package data.model;

import data.repository.Storable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class User implements Storable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private List<String> friends;
    private boolean isActive;



    public User(String firstName, String lastName, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = true;
    }


    public void setIsActive(boolean active) {
        isActive = active;
    }


    public boolean getIsActive() {
        return isActive;
    }


}
