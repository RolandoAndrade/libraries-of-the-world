package client.domain;

import shared.domain.Author;
import shared.domain.Book;

public interface LibraryRepository {
    Book getBook();
    Author getAuthor();
}
