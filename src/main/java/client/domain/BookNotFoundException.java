package client.domain;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book not found");
    }
}
