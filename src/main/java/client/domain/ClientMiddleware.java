package client.domain;

import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.domain.requests.Command;
import shared.domain.requests.Response;

public interface ClientMiddleware {
    /**
     * Translate the command to Z39 language then
     * request to remote repository
     */
    Response request(Command command, Library remote, String args, Command returnCommand) throws Exception;
}
