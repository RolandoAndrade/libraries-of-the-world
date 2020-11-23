package shared.domain.components;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
