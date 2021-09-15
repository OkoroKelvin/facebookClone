package exceptions;

public class unAuthenticatedUser extends Exception {
    public unAuthenticatedUser(String message) {
        super(message);
    }
}
