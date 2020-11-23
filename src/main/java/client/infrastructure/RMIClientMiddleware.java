package client.infrastructure;

import client.domain.ClientMiddleware;
import server.application.RemoteServerService;
import shared.domain.components.Library;
import shared.domain.logging.LoggerService;
import shared.domain.requests.Command;

import java.rmi.Naming;

public class RMIClientMiddleware implements ClientMiddleware {
    private final Library library;
    private final LoggerService loggerService;

    public RMIClientMiddleware(Library library, LoggerService loggerService){
        this.library = library;
        this.loggerService = loggerService;
    }

    @Override
    public <Book> Book request(Command command, String remote, String args) throws Exception {
        this.loggerService.log("request: translating " + command.getCommand() + " into " + command.getGeneralCommand(),
                "RMIClientMiddleware", "");
        String z39Command = command.getGeneralCommand();

        this.loggerService.log("request: request " + z39Command + " " +args + " to " + remote,
                "RMIClientMiddleware", "");
        RemoteServerService remoteServerService = (RemoteServerService) Naming.lookup(remote);
        return remoteServerService.request(z39Command, this.library.toString(), args);
    }
}
