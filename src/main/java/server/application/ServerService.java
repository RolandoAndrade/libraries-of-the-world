package server.application;

import server.domain.ServerRepository;
import shared.domain.Book;
import shared.domain.LoggerService;

import java.util.List;

public class ServerService {

    private ServerRepository repository;
    private LoggerService loggerService;
    private String libraryName;

    protected ServerService(String libraryName, ServerRepository repository, LoggerService loggerService){
        this.libraryName = libraryName;
        this.repository = repository;
        this.loggerService = loggerService;
    }

    Book getBook(String title, String originLibraryName){
        this.loggerService.log("[Library " +this.libraryName +"]  getBook: getting a book with name: "
                + title + " requested by Library " + originLibraryName , "ServerService", "");
        return this.repository.getBook(title, this.libraryName);
    }

    List<Book> getAuthor(String name, String surname, String originLibraryName){
        this.loggerService.log("[Library " +this.libraryName +"]  getAuthor: getting books og author: "
                + name + " " + surname + " requested by Library " + originLibraryName , "ServerService", "");
        return this.repository.getAuthor(name, surname, this.libraryName);
    }
}
