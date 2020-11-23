package client;

import client.application.LibraryService;
import client.domain.BookNotFoundException;
import org.junit.Before;
import org.junit.Test;
import shared.domain.*;
import shared.infrastructure.ConsoleLogger;
import shared.infrastructure.firstlibrary.FirstLibraryCommandSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryServiceTest {

    private RequestRepository repository;
    private LibraryService service;

    @Before
    public void setup() {
        this.repository = mock(RequestRepository.class);
        Z39CommandSet commandSet = new Z39CommandSet() {
            @Override
            public String getBookCommand() {
                return null;
            }

            @Override
            public String getAuthorCommand() {
                return null;
            }
        }
        this.service = new LibraryService(this.repository, new ConsoleLogger(), new FirstLibraryCommandSet(commandSet));
    }

    @Test
    public void getBook() throws Exception {
        String title = "Implementing Domain Driven Design";
        when(this.repository.request(anyString(), anyString())).thenReturn(new Book(title));
        Book book = this.service.getBook(title);
        assertEquals(title, book.getTitle());

    }

    @Test(expected = BookNotFoundException.class)
    public void getBookThatCannotBeFound() throws Exception {
        String title = "Harry Potter";
        when(this.repository.request(anyString(), anyString())).thenReturn(null);
        Book book = this.service.getBook(title);
    }


    @Test
    public void getAuthor() {
    }
}