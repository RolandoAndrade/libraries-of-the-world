package server.domain;

import shared.domain.requests.Response;

public interface ServerService {

    /**
     * Listen request of the clients
     */
    Response request(String command, String origin, String args) throws Exception;
}
