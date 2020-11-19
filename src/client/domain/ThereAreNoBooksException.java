package client.domain;

public class ThereAreNoBooksException extends Exception {
    public ThereAreNoBooksException(){
        super("There are no books to show");
    }
}
