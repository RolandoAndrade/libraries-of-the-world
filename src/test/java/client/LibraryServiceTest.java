package client;

import client.application.LibraryService;
import client.domain.BookNotFoundException;
import client.domain.ClientMiddleware;
import client.domain.ThereAreNoBooksException;
import org.junit.Before;
import org.junit.Test;
import shared.domain.components.Book;
import shared.domain.database.DataRepository;
import shared.domain.requests.CommandSet;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.librarya.LibraryACommandSet;
import shared.infrastructure.z39.Z39Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryServiceTest {

    private DataRepository repository;
    private ClientMiddleware middleware;
    private CommandSet commandSet;
    private LibraryService service;

    @Before
    public void setup() {
        this.repository = mock(DataRepository.class);
        this.middleware = mock(ClientMiddleware.class);
        this.commandSet = new LibraryACommandSet(new Z39Commands());
        this.service = new LibraryService(repository, middleware, commandSet, new ConsoleLogger());
    }

    @Test
    public void getBook() throws Exception {
        String title = "Implementing Domain Driven Design";
        when(this.repository.getBook(anyString())).thenReturn(new Book(title));
        Book book = this.service.getBook(title);
        assertEquals(title, book.getTitle());

    }

    @Test(expected = BookNotFoundException.class)
    public void getBookThatCannotBeFound() throws Exception {
        String title = "Harry Potter";
        when(this.repository.getBook(anyString())).thenReturn(null);
        Book book = this.service.getBook(title);
    }


    @Test
    public void getAuthor() throws Exception {
        String name = "Vaughn";
        String surname = "Vernon";
        when(this.repository.getAuthor(anyString())).thenReturn(new ArrayList<>(
                Arrays.asList(new Book("Implementing Domain Driven Design"),
                        new Book("Domain Driven Design Distilled"))
        ));
        List<Book> books = this.service.getAuthor(name, surname);
        assertEquals(books.size(), 2);
    }

    @Test(expected = ThereAreNoBooksException.class)
    public void getThereAreNoBooks() throws Exception {
        String name = "Jason";
        String surname = "Bourne";
        when(this.repository.getAuthor(anyString())).thenReturn(new ArrayList<>());
        List<Book> books = this.service.getAuthor(name, surname);
    }
}