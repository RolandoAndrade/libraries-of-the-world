package shared.infrastructure.firstlibrary;

import shared.domain.LibraryCommandSet;
import shared.domain.Z39CommandSet;

public class FirstLibraryCommandSet extends LibraryCommandSet {
    public FirstLibraryCommandSet(Z39CommandSet z39CommandSet) {
        super(z39CommandSet);
    }

    @Override
    public String getLibrary() {
        return "Library A";
    }

    @Override
    public String getBookCommand() {
        return "Pedir Libro";
    }

    @Override
    public String getAuthorCommand() {
        return "Pedir Autor";
    }

}
