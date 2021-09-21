package exceptions;

public class UserDoesNotExistException extends unAuthenticatedUser{
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
