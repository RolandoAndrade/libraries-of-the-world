package application.views.booksfinder;

import shared.domain.components.Library;

public class LibraryComboItem {
    private Library library;

    public LibraryComboItem(Library library){
        this.library = library;
    }

    @Override
    public String toString() {
        return library.getName();
    }

    public Library getValue() {
        return library;
    }
}
