package server.domain;

import shared.domain.requests.Response;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote, ServerService {
    @Override
    Response request(String command, String origin, String args) throws RemoteException, InterruptedException;
}
