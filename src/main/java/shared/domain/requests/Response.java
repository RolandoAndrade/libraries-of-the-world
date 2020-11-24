package shared.domain.requests;

public interface Response {
    <Book> Book getBody();
    String getCommand();
}
