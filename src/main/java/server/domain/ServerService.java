package server.domain;

public interface ServerService {
    <Book> Book request(String command, String origin, String args) throws Exception;
}
