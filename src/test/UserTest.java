
import data.dto.UserDto;
import data.model.User;
import data.repository.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.UserService;
import services.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest {

    private UserDto kelvin;
    private UserDto Janet;
    private UserDto John;

    private UserDatabase<User> userDatabase;
    private UserService userService;

    @BeforeEach
    void setUp() {
        kelvin = new UserDto("Kelvin", "obi", "obi@gmail.com", "obi123");
        Janet = new UserDto("Janet", "ishola", "janet@gmail.com", "janet123");
        John = new UserDto("John", "jonas", "john@gmail.com", "john123");

        userService = new UserServiceImpl();
        userDatabase = UserDatabase.getInstance();
    }

    @AfterEach
    void tearDown() {
        kelvin = null;
        Janet = null;
        John = null;
    }

    @Test
    @DisplayName("User can be created")
    void canCreateUserWhenConstructorIsInitializeTest(){
        assertAll(
                ()-> assertEquals(kelvin.getFirstName(), "Kelvin"),
                () -> assertEquals(Janet.getFirstName(), "Janet"),
                () -> assertEquals(John.getFirstName(), "John")
        );
    }

    @Test
    @DisplayName("User can register")
    void userCanRegisterTest(){
        userService.register(kelvin);
        assertThat(userDatabase.size()).isEqualTo(1);
        assertThat(userDatabase.store().get(0).getFirstName()).isEqualTo("Kelvin");
    }

    @Test
    @DisplayName("Instance is the same all through")
    void UserDatabaseReturnTheSameInstanceTest(){
        UserDatabase<User> userDatabase1 = UserDatabase.getInstance();
        UserDatabase<User> userDatabase2 = UserDatabase.getInstance();
        assertThat(userDatabase1).isEqualTo(userDatabase2);
    }

    @Test
    @DisplayName("User can post")
    void userHasAPost(){

    }
}