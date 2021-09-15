import data.dto.PostDto;
import data.dto.UserDto;
import data.model.Post;
import data.model.User;
import data.repository.PostDatabase;
import data.repository.UserDatabase;
import exceptions.unAuthenticatedUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.PostService;
import services.PostServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {
    private PostDto postDto;
    private PostService postService;
    private PostDatabase<Post> postDatabase;
    private UserService userService;
    private UserDatabase<User> userDatabase;

    @BeforeEach
    void setUp(){
        UserDto userDto = new UserDto("janet", "ishola", "jane@gmail.com", "1234");
        postDto = new PostDto("1", "my post", "hey");
        postService = new PostServiceImpl();
        postDatabase = PostDatabase.getInstance();
         userService = new UserServiceImpl();
         userDatabase = UserDatabase.getInstance();
    }
    @Test
    void postCanBeCreatedAtTheInitialization(){
        assertAll(
                () -> assertEquals(postDto.getUserId(), "1"),
                () -> assertEquals(postDto.getText(), "my post"),
                () -> assertEquals(postDto.getContent(), "hey")
        );
    }

    @Test
    @DisplayName("User can post")
    void userCanPostTest(){
        postService.save(postDto);
        assertThat(postDatabase.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("User can view all post")
    void userCanViewAllPost() throws unAuthenticatedUser {
        UserDto kelvin = new UserDto("Kelvin", "obi", "obi@gmail.com", "obi123");
        postService.save(postDto);
        userService.register(kelvin);
        User user = userDatabase.findByEmail("obi@gmail.com");
        List<Post> posts = postService.viewPost(user.getEmail());
        assertThat(posts.size()).isEqualTo(1);
    }

}
