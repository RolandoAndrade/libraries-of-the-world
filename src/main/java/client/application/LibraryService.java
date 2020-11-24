package client.application;

import client.domain.BookNotFoundException;
import client.domain.ClientMiddleware;
import client.domain.ThereAreNoBooksException;
import shared.domain.components.Book;
import shared.domain.components.Library;
import shared.domain.database.DataRepository;
import shared.domain.logging.LoggerService;
import shared.domain.requests.CommandSet;
import shared.domain.requests.Response;

import java.util.List;

public class LibraryService {

    private final DataRepository repository;
    private final ClientMiddleware clientMiddleware;
    private final LoggerService loggerService;
    private final CommandSet commandSet;

    public LibraryService(DataRepository repository,
                          ClientMiddleware clientMiddleware,
                          CommandSet commandSet,
                          LoggerService loggerService) {
        this.repository = repository;
        this.clientMiddleware = clientMiddleware;
        this.loggerService = loggerService;
        this.commandSet = commandSet;
    }

    /**
     * CU-001 GET BOOK AT LIBRARY USE CASE:
     * Given a name of a book, system should search the book and retrieve it.
     * If the book couldn't be reached, throws an exception
     */
    public Book getBook(String title) throws Exception {
        this.loggerService.log("getBook: getting book ", "LibraryService", commandSet.getBookCommand().getCommand() + " " + title);

        Book book = this.repository.getBook(title);
        if (book == null) {
            this.loggerService.error("getBook: book not found: ", "LibraryService", title);
            throw new BookNotFoundException();
        }

        this.loggerService.info("getBook: book fetched: ", "LibraryService", book);
        return book;
    }

    /**
     * CU-002 GET AUTHOR AT LIBRARY USE CASE:
     * Given a name of an author, system should search the its books and retrieve them.
     * If there are no books with this author, should return an exception
     */
    public List<Book> getAuthor(String name, String surname) throws Exception {
        String fullName = name + " " + surname;

        this.loggerService.log("getAuthor: getting books ", "LibraryService",
                commandSet.getAuthorCommand().getCommand() + " " + fullName);

        List<Book> books = this.repository.getAuthor(fullName);
        if (books.size() == 0) {
            this.loggerService.error("getAuthor: author has no books : ", "LibraryService", fullName);
            throw new ThereAreNoBooksException();
        }

        this.loggerService.info("getAuthor: fetched " + books.size() + " books ", "LibraryService", "");
        return books;
    }

    /**
     * CU-003 GET BOOK AT REMOTE LIBRARY USE CASE:
     * Given a name of a book, system should search the book and retrieve it.
     * If the book couldn't be reached, throws an exception
     */
    public Response getBook(String title, Library library) throws Exception {
        this.loggerService.log("getBook: getting a book at library" + library.getName(),
                "LibraryService", commandSet.getBookCommand().getCommand() + " " + title);

        Response response = this.clientMiddleware.request(commandSet.getBookCommand(), library.getAddress(), title, commandSet.returnBookCommand());
        if (response.getBody() == null) {
            throw new BookNotFoundException();
        }

        this.loggerService.info("getBook: book fetched from library " + library.getName() + ": ", "LibraryService", response);
        return response;
    }
}
