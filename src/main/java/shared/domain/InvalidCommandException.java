package shared.domain;

public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Invalid command");
    }
}
