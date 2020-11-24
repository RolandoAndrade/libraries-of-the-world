package shared.domain.requests;

public interface CommandSet {
    Command getBookCommand();
    Command getAuthorCommand();
    Command returnBookCommand();
    Command returnAuthorCommand();
}
