package shared.domain.components;

import java.util.List;

public class LibraryConfiguration {
    private Library currentLibrary;
    private List<Library> libraries;

    public Library getCurrentLibrary() {
        return currentLibrary;
    }

    public List<Library> getLibraries() {
        return libraries;
    }
}
