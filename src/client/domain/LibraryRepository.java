package client.domain;

import shared.domain.Book;

import java.util.List;

public interface LibraryRepository {
    Book getBook(String title);

    List<Book> getAuthor(String name, String surname);

    List<Book> getLibrary(String name);
}
