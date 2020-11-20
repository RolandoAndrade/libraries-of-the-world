package client.mocks;

import client.domain.LibraryRepository;
import shared.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepositoryMock implements LibraryRepository {
    @Override
    public Book getBook(String title) {
        return new Book("Implementing domain driven design");
    }

    @Override
    public List<Book> getAuthor(String name, String surname) {
        return null;
    }

    @Override
    public List<Book> getLibrary(String name) {
        return null;
    }
}
