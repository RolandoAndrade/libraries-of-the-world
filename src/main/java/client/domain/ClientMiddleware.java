package client.domain;

import shared.domain.components.Address;
import shared.domain.requests.Command;

public interface ClientMiddleware {
    /**
     * Translate the command to Z39 language then
     * request to remote repository
     */
    <Book> Book request(Command command, Address remote, String args) throws Exception;
}
