package client.infrastructure;

import client.domain.ClientMiddleware;
import server.domain.RemoteService;
import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.domain.logging.LoggerService;
import shared.domain.requests.Command;
import shared.domain.requests.InvalidCommandException;
import shared.domain.requests.Response;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIClientMiddleware implements ClientMiddleware {
    private final Library library;
    private final LoggerService loggerService;

    public RMIClientMiddleware(Library library, LoggerService loggerService) {
        this.library = library;
        this.loggerService = loggerService;
    }


    /**
     * Translates the Z39 response into Library Language
     * */
    private Response translateResponse(Response response, Command returnCommand) throws InvalidCommandException {
        this.loggerService.log("translateResponse: translating " + response.getCommand(),
                "RMIClientMiddleware", "");

        if (response.getCommand().equals(returnCommand.getGeneralCommand())) {

            this.loggerService.info("translateResponse>: the translated response command is ", "RMIClientMiddleware",
                    returnCommand.getCommand());
            response.setCommand(returnCommand.getCommand());

            return response;
        }

        this.loggerService.error("Invalid Z39 command", "RMIClientMiddleware", response.getCommand());
        throw new InvalidCommandException();
    }


    /**
     * Translate the command to Z39 language then
     * request to remote repository and finally request the translation
     * of the Z39 response into Library Language
     */
    @Override
    public Response request(Command command, Library remote, String args, Command returnCommand) throws Exception {
        this.loggerService.log("request: translating " + command.getCommand() + " into " + command.getGeneralCommand(),
                "RMIClientMiddleware", "");
        String z39Command = command.getGeneralCommand();

        this.loggerService.log("request: request " + z39Command + " " + args + " to " + remote,
                "RMIClientMiddleware", "");

        RemoteService remoteServerService = (RemoteService) Naming.lookup(remote.getAddress().getAddress());
        Response response = remoteServerService.request(z39Command, this.library.toString(), args);

        this.loggerService.info("request: received response ",
                "RMIClientMiddleware", response);

        return translateResponse(response, returnCommand);
    }
}
