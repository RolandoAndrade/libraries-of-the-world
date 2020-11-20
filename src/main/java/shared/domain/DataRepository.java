package shared.domain;

import java.util.List;

public interface DataRepository {
    Book getBook(String title);

    List<Book> getAuthor(String name, String surname);

    List<Book> getLibrary(String name);
}
