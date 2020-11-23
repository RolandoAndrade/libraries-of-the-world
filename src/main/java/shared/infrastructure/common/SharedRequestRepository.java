package shared.infrastructure.common;

import server.application.RemoteServerService;
import shared.domain.database.DataRepository;
import shared.domain.requests.LibraryCommandSet;
import shared.domain.requests.RequestRepository;

import java.rmi.Naming;

public class SharedRequestRepository implements RequestRepository {

    private final DataRepository dataRepository;
    private final LibraryCommandSet commandSet;

    public SharedRequestRepository(DataRepository dataRepository, LibraryCommandSet commandSet) {
        this.dataRepository = dataRepository;
        this.commandSet = commandSet;
    }

    @Override
    public <Book> Book request(String command, String args) throws Exception {
        if (commandSet.getBookCommand().equals(command)) {
            return (Book) this.dataRepository.getBook(args);
        } else if (commandSet.getAuthorCommand().equals(command)) {
            return (Book) this.dataRepository.getAuthor(args);
        }
        return null;
    }

    @Override
    public <Book> Book request(String command, String origin, String remote, String args) throws Exception {
        RemoteServerService remoteServerService = (RemoteServerService) Naming.lookup(remote);
        return remoteServerService.request(command, origin, args);
    }
}
