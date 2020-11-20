package client.domain;

import shared.domain.Book;

import java.util.List;

public interface RemoteLibraryRepository {
    <Book> Book request(String command, String arguments);
}
