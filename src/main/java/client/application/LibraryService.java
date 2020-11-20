package client.application;

import client.domain.BookNotFoundException;
import client.domain.ThereAreNoBooksException;
import shared.domain.RequestRepository;
import shared.domain.*;

import java.util.List;

public class LibraryService {
    private RequestRepository requestRepository;
    private LoggerService loggerService;
    private LibraryCommandSet commandSet;

    public LibraryService(RequestRepository requestRepository,
                          LoggerService loggerService,
                          LibraryCommandSet commandSet) {
        this.requestRepository = requestRepository;
        this.loggerService = loggerService;
        this.commandSet = commandSet;
    }

    /**
     * CU-001 GET BOOK AT LIBRARY USE CASE:
     * Given a name of a book, system should search the book and retrieve it.
     * If the book couldn't be reached, throws an exception
     */
    public Book getBook(String name) throws Exception {
        this.loggerService.log("getBook: getting book ", "LibraryService", commandSet.getBookCommand() + " " + name);

        Book book = this.requestRepository.request(commandSet.getBookCommand(), name);
        if (book == null) {
            this.loggerService.error("getBook: book not found: ", "LibraryService", name);
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
        this.loggerService.log("getAuthor: getting books ", "LibraryService",
                commandSet.getAuthorCommand() + " " + name + " " + surname);

        List<Book> books = this.requestRepository.request(commandSet.getBookCommand(), name + " " + surname);
        if (books.size() == 0) {
            this.loggerService.error("getAuthor: author has no books : ", "LibraryService", name + " " + surname);
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
    public Book getBook(String name, Library library) throws Exception {
        this.loggerService.log("getBook: getting a book at library"  + library.getName(),
                "LibraryService", commandSet.getZ39BookCommand() + " " + name);

        Book book = this.requestRepository.request(commandSet.getZ39BookCommand(), commandSet.getLibrary(), library.getName(), name);
        if (book == null) {
            throw new BookNotFoundException();
        }

        this.loggerService.info("getBook: book fetched from library " +library.getName()+": ", "LibraryService", book);
        return book;
    }
}
