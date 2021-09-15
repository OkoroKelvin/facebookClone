import data.dto.PostDto;
import data.dto.UserDto;
import data.model.Post;
import data.model.User;
import data.repository.PostDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.PostService;
import services.PostServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {
    private PostDto postDto;
    private UserDto userDto;
    private PostService postService;
    private PostDatabase postDatabase;

    @BeforeEach
    void setUp(){
        userDto = new UserDto("janet", "ishola", "jane@gmail.com", "1234");
        postDto = new PostDto("1", "my post", "hey");
        postService = new PostServiceImpl();
        postDatabase = PostDatabase.getInstance();
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

}
