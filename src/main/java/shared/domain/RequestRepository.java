package shared.domain;

public interface RequestRepository {

    /**
     * Request to local repository
     */
    <Book> Book request(String command, String args) throws Exception;

    /**
     * Request to remote repository
     */
    <Book> Book request(String command, String origin, String remote, String args) throws Exception;
}
