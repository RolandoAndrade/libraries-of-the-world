package application.infrastructure;

import application.domain.EventBus;
import application.domain.SearchRequest;
import application.domain.Subscriber;
import application.views.shared.Utilities;
import client.application.LibraryService;
import client.infrastructure.RMIClientMiddleware;
import shared.domain.components.Book;
import shared.domain.components.Library;
import shared.domain.logging.LoggerService;
import shared.domain.requests.CommandSet;
import shared.infrastructure.common.FileRepository;

import java.util.ArrayList;
import java.util.List;

public class GenericClient implements Subscriber {
    private final LibraryService libraryService;
    private final Library currentLibrary;
    private final LoggerService logger;

    public GenericClient(LoggerService logger, CommandSet libraryCommandSet, String[] args){
        this.logger = logger;
        String filePath = "templates/library-template.xml";
        if (args.length > 0) {
            filePath = args[0];
        } else {
            logger.info("repository not defined, using default library-template.xml", "GenericClient", "");
        }

        currentLibrary = Utilities.getConfiguration().getCurrentLibrary();
        libraryService = new LibraryService(new FileRepository(ClassLoader.getSystemResource(filePath).getPath()),
                new RMIClientMiddleware(currentLibrary, logger),
                libraryCommandSet, logger);
        logger.log("started client ", "GenericClient", currentLibrary);
        EventBus.subscribe(this);
    }

    @Override
    public void listen(String subject, Object message) {
        try{
            if(subject.equals(EventBus.GET_BOOK)){
                SearchRequest searchRequest = (SearchRequest) message;
                Book book;
                if(searchRequest.isSameLibrary(currentLibrary)){
                    book = libraryService.getBook(searchRequest.getName());
                }
                else {
                    book = libraryService.getBook(searchRequest.getName(), searchRequest.getLibrary()).getBody();
                }
                EventBus.emit(EventBus.BOOK_RECEIVED, book);
            }
            else if(subject.equals(EventBus.GET_AUTHOR)){
                SearchRequest searchRequest = (SearchRequest) message;
                String name = searchRequest.getName().split(" ")[0];
                String surname = searchRequest.getName().split(" ")[1];
                List<Book> books = new ArrayList<>();
                if(searchRequest.isSameLibrary(currentLibrary)){
                    books = libraryService.getAuthor(name, surname);
                }
                else {
                    books = libraryService.getAuthor(name, surname, searchRequest.getLibrary()).getBody();
                }
                EventBus.emit(EventBus.BOOKS_RECEIVED, books);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), "GenericClient", "");
            EventBus.emit(EventBus.BOOK_RECEIVED, null);
        }

    }
}
