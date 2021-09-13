package data.dto;

import data.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public static User unPackDto(UserDto userDto){
        return new User(userDto.getFirstName(), userDto.getLastName(),  userDto.getEmail(), userDto.getPassword());
    }


}

