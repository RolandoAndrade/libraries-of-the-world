package shared.infrastructure.common;

import shared.domain.components.Book;
import shared.domain.requests.Response;

public class BookResponse implements Response {

    private final Book book;
    private String command;

    public BookResponse(Book book, String command) {
        this.book = book;
        this.command = command;
    }

    @Override
    public Book getBody() {
        return book;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command + " " + book;
    }
}
