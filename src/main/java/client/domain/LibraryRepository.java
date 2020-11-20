package client.domain;

import shared.domain.Book;

import java.util.List;

public interface LibraryRepository {
    <Book> Book request(String command, String arguments);
    
}
