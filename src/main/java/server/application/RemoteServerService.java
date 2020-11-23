package server.application;

import shared.domain.InvalidCommandException;
import shared.domain.LibraryCommandSet;
import shared.domain.LoggerService;
import shared.domain.RequestRepository;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerService extends UnicastRemoteObject implements ServerService, Remote {

    private final LoggerService loggerService;
    private final LibraryCommandSet commandSet;
    private final RequestRepository requestRepository;


    public RemoteServerService(RequestRepository requestRepository, LoggerService loggerService, LibraryCommandSet commandSet) throws RemoteException {
        super();
        this.requestRepository = requestRepository;
        this.loggerService = loggerService;
        this.commandSet = commandSet;
    }

    public <Book> Book request(String command, String origin, String args) throws Exception {
        this.loggerService.log("request: " + command + " " + args + " from " + origin, "RemoteServerService", "");
        String translatedCommand;
        try {
            translatedCommand = commandSet.translateCommand(command);
        } catch (InvalidCommandException e) {
            this.loggerService.error(e.getMessage(), "RemoteServerService", "");
            return null;
        }

        return this.requestRepository.request(translatedCommand, args);
    }
}
