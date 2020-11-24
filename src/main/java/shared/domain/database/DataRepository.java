package shared.domain.database;

import shared.domain.components.Book;

import java.util.List;

public interface DataRepository {

    /**
     * Get a book by title
     * */
    Book getBook(String title) throws Exception;

    /**
     * Get a list of books of author
     * */
    List<Book> getAuthor(String fullName) throws Exception;
}
