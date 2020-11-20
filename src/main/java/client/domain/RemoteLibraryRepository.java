package client.domain;

public interface RemoteLibraryRepository {
    <Book> Book request(String command, String arguments);
}
