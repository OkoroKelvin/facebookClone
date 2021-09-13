package services;

import data.dto.UserDto;
import data.model.User;
import data.repository.UserDatabase;

public class UserServiceImpl implements UserService{

    private final UserDatabase<User> userDatabase = UserDatabase.getInstance();

    @Override
    public void register(UserDto userDto) {
        if (userDto == null) throw new NullPointerException("User cannot be null");
        User user = UserDto.unPackDto(userDto);
        userDatabase.save(user);
    }
}
