package shared.domain;

import java.util.List;

public interface DataRepository {
    Book getBook(String title) throws Exception;

    List<Book> getAuthor(String name, String surname) throws Exception;

    List<Book> getLibrary(String name) throws Exception;
}
