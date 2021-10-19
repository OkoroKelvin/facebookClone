package services;

import data.dto.PostDto;
import data.dto.UserDto;
import data.model.Post;
import data.model.User;
import data.repository.PostDatabase;
import data.repository.UserDatabase;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDatabase<User> userDatabase = UserDatabase.getInstance();
    private final PostDatabase<Post> postDatabase = PostDatabase.getInstance();


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
                System.out.println(user);
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

    @Override
    public void createPost(PostDto postDto, String email) {
        Post post = new Post(postDto.getText(), postDto.getContent(), email);
        postDatabase.save(post);
    }
}
