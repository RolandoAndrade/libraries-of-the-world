package shared.infrastructure.common;

import shared.domain.components.Book;
import shared.domain.requests.Response;

import java.util.List;

public class AuthorResponse implements Response {
    private final List<Book> books;
    private String command;

    public AuthorResponse(List<Book> books, String command) {
        this.books = books;
        this.command = command;
    }

    @Override
    public List<Book> getBody() {
        return books;
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
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b.toString());
            sb.append(", ");
        }

        return command + "[" + sb.toString() + "]";
    }
}
