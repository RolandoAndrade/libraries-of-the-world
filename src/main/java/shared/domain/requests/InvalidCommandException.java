package shared.domain.requests;

public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Invalid command");
    }
}
