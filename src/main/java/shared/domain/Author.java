package shared.domain;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }
}
