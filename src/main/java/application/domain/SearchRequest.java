package application.domain;


import shared.domain.components.Library;

public class SearchRequest {
    private String name;
    private Library library;

    public SearchRequest(String name, Library library){
        this.name = name;
        this.library = library;
    }

    public boolean isSameLibrary(Library library){
        return this.library.getName().equals(library.getName());
    }

    public String getName() {
        return name;
    }

    public Library getLibrary() {
        return library;
    }
}
