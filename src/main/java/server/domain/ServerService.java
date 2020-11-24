package server.domain;

import shared.domain.requests.Response;

public interface ServerService {
    Response request(String command, String origin, String args) throws Exception;
}
