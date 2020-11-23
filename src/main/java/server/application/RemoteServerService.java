package server.application;

import shared.domain.database.DataRepository;
import shared.domain.logging.LoggerService;
import shared.domain.requests.CommandSet;
import shared.domain.requests.InvalidCommandException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerService extends UnicastRemoteObject implements ServerService, Remote {


    private final DataRepository dataRepository;
    private final CommandSet commandSet;
    private final LoggerService loggerService;

    private static boolean isRequestInProgress;

    public RemoteServerService(DataRepository dataRepository, CommandSet commandSet, LoggerService loggerService) throws RemoteException {
        super();
        this.dataRepository = dataRepository;
        this.commandSet = commandSet;
        this.loggerService = loggerService;
    }


    public <Book> Book makeRequest(String command, String args) throws Exception {
        this.loggerService.log("makeRequest: translating z39 command " + command, "RemoteServerService", "");

        if(commandSet.getBookCommand().getGeneralCommand().equals(command)) {
            this.loggerService.info("makeRequest: the translated command is ", "RemoteServerService",
                    commandSet.getBookCommand().getCommand() + " " +args);

            return (Book) this.dataRepository.getBook(args);
        } else if(commandSet.getAuthorCommand().getGeneralCommand().equals(command)){
            this.loggerService.info("makeRequest: the translated command is ", "RemoteServerService",
                    commandSet.getBookCommand().getCommand() + " " +args);

            return (Book) this.dataRepository.getAuthor(args);
        }

        this.loggerService.error("makeRequest: invalid command ", "RemoteServerService",
                command);
        throw new InvalidCommandException();
    }

    public synchronized <Book> Book request(String command, String origin, String args) throws Exception {
        /*while (isRequestInProgress){
            this.loggerService.info("request: there is a request in progress, please wait", "RemoteServerService", "");
            wait();
        }

        isRequestInProgress = true;
        notifyAll();*/

        this.loggerService.log("request: " + command + " " + args + " from " + origin, "RemoteServerService", "");

        Book response = makeRequest(command, args);

        /*
        isRequestInProgress = false;
        notifyAll();
        */
        return response;
    }
}
