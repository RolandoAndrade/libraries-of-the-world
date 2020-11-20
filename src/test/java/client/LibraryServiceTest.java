package client;

import client.application.LibraryService;
import client.domain.BookNotFoundException;
import org.junit.Before;
import org.junit.Test;
import shared.domain.Book;
import shared.domain.LibraryCommandSet;
import shared.domain.RequestRepository;
import shared.infrastructure.ConsoleLogger;

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
        this.service = new LibraryService(this.repository, new ConsoleLogger(), new LibraryCommandSet() {
            @Override
            public String getLibrary() {
                return "MOCK LIBRARY";
            }

            @Override
            public String getBookCommand() {
                return "GET BOOK";
            }

            @Override
            public String getAuthorCommand() {
                return "GET AUTHOR";
            }

            @Override
            public String getZ39BookCommand() {
                return "GETZ39 BOOK";
            }

            @Override
            public String getZ39AuthorCommand() {
                return "GETZ39 AUTHOR";
            }
        });
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