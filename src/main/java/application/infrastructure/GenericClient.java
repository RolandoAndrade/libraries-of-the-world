package application.infrastructure;

import application.domain.EventBus;
import application.domain.SearchRequest;
import application.domain.Subscriber;
import application.views.shared.Utilities;
import client.application.LibraryService;
import client.infrastructure.RMIClientMiddleware;
import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.domain.logging.LoggerService;
import shared.domain.requests.CommandSet;
import shared.infrastructure.common.FileRepository;

public class GenericClient implements Subscriber {
    private LibraryService libraryService;
    private Library currentLibrary;

    public GenericClient(LoggerService logger, CommandSet libraryCommandSet, String[] args){
        int port = 8080;
        String filePath = "src/main/resources/templates/library-template.xml";
        if (args.length > 0) {
            port = Math.max(Integer.parseInt(args[0]), 2000);
            if (args.length > 1) {
                filePath = args[1];
            } else {
                logger.info("repository not defined, using default library-template.xml", "GenericServer", "");
            }
        } else {
            logger.info("port is not defined, using default 3000", "GenericClient", "");
            logger.info("repository not defined, using default library-template.xml", "GenericClient", "");
        }

        currentLibrary = Utilities.getConfiguration().getCurrentLibrary();
        libraryService = new LibraryService(new FileRepository(filePath),
                new RMIClientMiddleware(currentLibrary, logger),
                libraryCommandSet, logger);
        logger.log("started client ", "GenericClient", currentLibrary);
    }

    @Override
    public void listen(String subject, Object message) {
        try{
            if(subject.equals(EventBus.GET_BOOK)){
                SearchRequest searchRequest = (SearchRequest) message;
                if(searchRequest.isSameLibrary(currentLibrary)){
                    libraryService.getBook(searchRequest.getName());
                }
                else {
                    libraryService.getBook(searchRequest.getName(), searchRequest.getLibrary());
                }
            }
            else if(subject.equals(EventBus.GET_AUTHOR)){
                SearchRequest searchRequest = (SearchRequest) message;
                String name = searchRequest.getName().split(" ")[0];
                String surname = searchRequest.getName().split(" ")[1];
                if(searchRequest.isSameLibrary(currentLibrary)){
                    libraryService.getAuthor(name, surname);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
