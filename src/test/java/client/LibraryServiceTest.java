package client;

import client.application.LibraryService;
import client.domain.BookNotFoundException;
import client.domain.RemoteLibraryRepository;
import org.junit.Before;
import org.junit.Test;
import shared.domain.Book;
import shared.domain.LibraryCommandSet;
import shared.infrastructure.ConsoleLogger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryServiceTest {

    private RemoteLibraryRepository repository;
    private LibraryService service;

    @Before
    public void setup() {
        this.repository = mock(RemoteLibraryRepository.class);
        this.service = new LibraryService(this.repository, new ConsoleLogger(), new LibraryCommandSet() {
            @Override
            public String getBookCommand() {
                return "PEDIR LIBRO";
            }

            @Override
            public String getAuthorCommand() {
                return "PEDIR AUTOR";
            }
        });
    }

    @Test
    public void getBook() throws BookNotFoundException {
        String title = "Implementing Domain Driven Design";
        when(this.repository.getBook(title)).thenReturn(new Book(title));
        Book book = this.service.getBook(title);
        assertEquals(title, book.getTitle());

    }

    @Test(expected = BookNotFoundException.class)
    public void getBookThatCannotBeFound() throws BookNotFoundException {
        String title = "Harry Potter";
        when(this.repository.getBook(title)).thenReturn(null);
        Book book = this.service.getBook(title);
    }


    @Test
    public void getAuthor() {
    }
}