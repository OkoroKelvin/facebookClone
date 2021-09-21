package services;

import data.dto.UserDto;

public interface UserService {
    void register(UserDto userDto);

    void login(String email, String password);

    void logout(String email);
}
