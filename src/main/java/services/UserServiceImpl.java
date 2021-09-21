package services;

import data.dto.UserDto;
import data.model.User;
import data.repository.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDatabase<User> userDatabase = UserDatabase.getInstance();


    @Override
    public void register(UserDto userDto) {
        if (userDto == null) throw new NullPointerException("User cannot be null");
        User user = UserDto.unPackDto(userDto);
        userDatabase.save(user);
    }


    @Override
    public void login(String email, String password) {
        List<User> allUsers = userDatabase.store();
        for (User user : allUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                user.setIsActive(true);
            }
        }
    }


    @Override
    public void logout(String email) {
        List<User> allUsers = userDatabase.store();
        for (User user : allUsers) {
            if (user.getEmail().equals(email)) {
                user.setIsActive(false);
            }
        }

    }
}
