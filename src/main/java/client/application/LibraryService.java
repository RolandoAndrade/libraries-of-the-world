package client.application;

import client.domain.BookNotFoundException;
import client.domain.RemoteLibraryRepository;
import client.domain.ThereAreNoBooksException;
import shared.domain.RequestRepository;
import shared.domain.*;

import java.util.List;

public class LibraryService {
    private RequestRepository requestRepository;
    private LoggerService loggerService;
    private LibraryCommandSet commandSet;

    public LibraryService(RequestRepository requestRepository,
                          RemoteLibraryRepository remoteLibraryRepository,
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
        this.loggerService.log("getBook: getting a book with name: ", "LibraryService", name);

        Book book = this.requestRepository.request(commandSet.getBookCommand(), name);
        if (book == null) {
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
        this.loggerService.log("getAuthor: getting books of the author: ", "LibraryService", name + " " + surname);
        List<Book> books = this.requestRepository.request(commandSet.getBookCommand(), name + " " + surname);
        if (books.size() == 0) {
            throw new ThereAreNoBooksException();
        }
        return books;
    }

    /**
     * CU-003 GET BOOK AT REMOTE LIBRARY USE CASE:
     * Given a name of a book, system should search the book and retrieve it.
     * If the book couldn't be reached, throws an exception
     */
    public Book getBook(String name, Library library) throws Exception {
        this.loggerService.log("getBook: getting at library"  + library.getName() + " a book with name: ", "LibraryService", name);
        Book book = this.requestRepository.request(commandSet.getBookCommand(), commandSet.getLibrary(), library.getName(), name);
        if (book == null) {
            throw new BookNotFoundException();
        }
        return book;
    }
}
