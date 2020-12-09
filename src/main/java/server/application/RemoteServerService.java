package server.application;

import server.domain.RemoteService;
import shared.domain.components.Book;
import shared.domain.database.DataRepository;
import shared.domain.logging.LoggerService;
import shared.domain.requests.CommandSet;
import shared.domain.requests.InvalidCommandException;
import shared.domain.requests.Response;
import shared.infrastructure.common.AuthorResponse;
import shared.infrastructure.common.BookResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteServerService extends UnicastRemoteObject implements RemoteService {


    private static boolean isRequestInProgress;
    private final DataRepository dataRepository;
    private final CommandSet commandSet;
    private final LoggerService loggerService;

    public RemoteServerService(DataRepository dataRepository, CommandSet commandSet, LoggerService loggerService) throws RemoteException {
        super();
        this.dataRepository = dataRepository;
        this.commandSet = commandSet;
        this.loggerService = loggerService;
    }

    /**
     * Makes the query and translate the response into Z39 language
     */
    private Response getBookResponse(String title) throws Exception {
        this.loggerService.info("getBookResponse: the translated command is ", "RemoteServerService",
                commandSet.getBookCommand().getCommand() + " " + title);


        this.loggerService.log("getBookResponse: getting book ", "RemoteServerService", "");
        Book book = this.dataRepository.getBook(title);

        this.loggerService.log("getBookResponse: translating response " + commandSet.returnBookCommand().getCommand() +
                        " into " + commandSet.returnBookCommand().getGeneralCommand(),
                "RemoteServerService", "");

        return new BookResponse(book, commandSet.returnBookCommand().getGeneralCommand());

    }


    /**
     * Makes the query and translate the response into Z39 language
     */
    private Response getAuthorResponse(String author) throws Exception {
        this.loggerService.info("getAuthorResponse: the translated command is ", "RemoteServerService",
                commandSet.getAuthorCommand().getCommand() + " " + author);

        this.loggerService.log("getAuthorResponse: getting books ", "RemoteServerService", "");
        List<Book> books = this.dataRepository.getAuthor(author);

        this.loggerService.log("getBookResponse: translating response " + commandSet.returnAuthorCommand().getCommand() +
                        " into " + commandSet.returnAuthorCommand().getGeneralCommand(),
                "RemoteServerService", "");

        return new AuthorResponse(books, commandSet.returnAuthorCommand().getGeneralCommand());
    }

    /**
     * Translates the Z39 command into Library Language and makes the request to the repository.
     * Then translate the library response into Z39 response
     */
    private Response makeRequest(String command, String args) throws Exception {
        this.loggerService.log("makeRequest: translating z39 command " + command, "RemoteServerService", "");


        if (commandSet.getBookCommand().getGeneralCommand().equals(command)) {
            return getBookResponse(args);
        } else if (commandSet.getAuthorCommand().getGeneralCommand().equals(command)) {
            return getAuthorResponse(args);
        }

        this.loggerService.error("makeRequest: invalid command ", "RemoteServerService",
                command);
        throw new InvalidCommandException();
    }


    /**
     * Listen request of the clients
     */
    public synchronized Response request(String command, String origin, String args) throws RemoteException, InterruptedException {
        while (isRequestInProgress){
            this.loggerService.info("request: there is a request in progress, please wait ", "RemoteServerService", origin);
            wait();
        }

        isRequestInProgress = true;
        notifyAll();

        try {
            this.loggerService.log("request: " + command + " " + args + " from " + origin, "RemoteServerService", "");

            Response response = makeRequest(command, args);

            this.loggerService.info("request: response to send -> ", "RemoteServerService", response);


        isRequestInProgress = false;
        notifyAll();

            return response;
        } catch (Exception e) {
            throw new RemoteException(e.getMessage());
        }

    }
}
