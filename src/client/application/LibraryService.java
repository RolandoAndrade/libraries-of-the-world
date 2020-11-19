package client.application;

import client.domain.BookNotFoundException;
import client.domain.LibraryRepository;
import client.domain.ThereAreNoBooksException;
import shared.domain.Book;
import shared.domain.LoggerService;

import java.util.List;

public class LibraryService {
    private LibraryRepository repository;
    private LoggerService loggerService;

    public LibraryService(LibraryRepository repository, LoggerService loggerService){
        this.repository = repository;
        this.loggerService = loggerService;
    }

    /**
     * CU-001 GET BOOK USE CASE:
     *
     * Given a name of a book, system should search the book and retrieve it.
     * If the book couldn't be reached, throws an exception
     */
    public Book getBook(String name) throws BookNotFoundException{
        this.loggerService.log("getBook: getting a book with name: ", "LibraryService", name);
        Book book = this.repository.getBook(name);
        if(book == null){
            throw new BookNotFoundException();
        }
        return book;
    }

    /**
     * CU-002 GET AUTHOR USE CASE:
     *
     * Given a name of an author, system should search the its books and retrieve them.
     * If there are no books with this author, should return an exception
     */
    public List<Book> getAuthor(String name, String surname) throws ThereAreNoBooksException{
        this.loggerService.log("getAuthor: getting books of the author: ", "LibraryService", name + " " + surname);
        List<Book> books = this.repository.getAuthor(name, surname);
        if(books.size()==0){
            throw new ThereAreNoBooksException();
        }
        return books;
    }
}
