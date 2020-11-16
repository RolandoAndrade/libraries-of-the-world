package shared.domain;

public class Book {
    private String title;
    private Author author;

    public Book(String title){
        this.title = title;
    }

    public Book(String title, Author author){
        this.title = title;
        this.author = author;
    }

    public String getTitle(){
        return this.title;
    }

    public Author getAuthor(){
        return this.author;
    }
}
