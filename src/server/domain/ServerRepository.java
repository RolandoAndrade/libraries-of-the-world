package server.domain;

import shared.domain.Author;
import shared.domain.Book;

public interface ServerRepository {
    Book getBook();
    Author getAuthor();
}
