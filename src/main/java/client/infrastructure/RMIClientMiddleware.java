package client.infrastructure;

import client.domain.ClientMiddleware;
import server.application.RemoteServerService;
import server.domain.RemoteService;
import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.domain.logging.LoggerService;
import shared.domain.requests.Command;

import java.rmi.registry.LocateRegistry;

public class RMIClientMiddleware implements ClientMiddleware {
    private final Library library;
    private final LoggerService loggerService;

    public RMIClientMiddleware(Library library, LoggerService loggerService){
        this.library = library;
        this.loggerService = loggerService;
    }

    @Override
    public <Book> Book request(Command command, Address remote, String args) throws Exception {
        this.loggerService.log("request: translating " + command.getCommand() + " into " + command.getGeneralCommand(),
                "RMIClientMiddleware", "");
        String z39Command = command.getGeneralCommand();

        this.loggerService.log("request: request " + z39Command + " " +args + " to " + remote,
                "RMIClientMiddleware", "");
        RemoteService remoteServerService = (RemoteService) LocateRegistry.getRegistry(remote.getPort()).lookup(remote.getAddress());
        return remoteServerService.request(z39Command, this.library.toString(), args);
    }
}
