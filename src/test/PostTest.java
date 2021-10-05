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
    private UserDto userDto;
    @BeforeEach
    void setUp(){
        userDto = new UserDto("janet", "ishola", "jane@gmail.com", "1234");
        postDto = new PostDto( "my post", "hey");
        postService = new PostServiceImpl();
        postDatabase = PostDatabase.getInstance();
         userService = new UserServiceImpl();
         userDatabase = UserDatabase.getInstance();
    }
    @Test
    void postCanBeCreatedAtTheInitialization(){
        assertAll(
                () -> assertEquals(postDto.getTitle(), "my post"),
                () -> assertEquals(postDto.getContent(), "hey")
        );
    }

    @Test
    @DisplayName("User can post")
    void postCanBeCreated(){
       UserDto kelvin = new UserDto("Kelvin", "obi", "obi@gmail.com", "obi123");
        userService.register(kelvin);
        assertThat(userDatabase.size()).isEqualTo(1);
        assertThat(userDatabase.store().get(0).getFirstName()).isEqualTo("Kelvin");
        postService.save(postDto, kelvin.getEmail());
        assertThat(postDatabase.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("User can view all post")
    void userCanViewAllPost() throws unAuthenticatedUser {
        //Given
        userService.register(userDto);
        postService.save(postDto, userDto.getEmail());
        postService.save(new PostDto("DSA", "Data structure and algorithm"), userDto.getEmail());
        postService.save(new PostDto("Currency", "Currency in java"), userDto.getEmail());

        //When
        List<Post> posts = postService.viewAllPost(userDto.getEmail());

        //Assert
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.get(0).getTitle()).isEqualTo("my post");
        assertThat(posts.get(0).getContent()).isEqualTo("hey");
    }



}
