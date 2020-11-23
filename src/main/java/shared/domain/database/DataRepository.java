package shared.domain.database;

import shared.domain.components.Book;

import java.util.List;

public interface DataRepository {
    Book getBook(String title) throws Exception;

    List<Book> getAuthor(String fullName) throws Exception;

    List<Book> getLibrary(String name) throws Exception;
}
