package server.domain;

import shared.domain.Book;

import java.util.List;

public interface ServerRepository {
    Book getBook(String title, String originLibraryName);

    List<Book> getAuthor(String name, String surname, String originLibraryName);

    List<Book> getLibrary(String name, String originLibraryName);
}
