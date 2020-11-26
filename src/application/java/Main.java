import client.application.LibraryService;
import client.infrastructure.RMIClientMiddleware;
import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.librarya.LibraryACommandSet;
import shared.infrastructure.z39.Z39Commands;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService(new FileRepository("/home/rolandoandrade/IdeaProjects/libraries-of-the-world/src/main/resources/templates/library-template.xml"),
                new RMIClientMiddleware(new Library("Library A",
                        new Address("127.0.0.1", 3001)),
                        new ConsoleLogger()), new LibraryACommandSet(new Z39Commands()), new ConsoleLogger());

        try {
            libraryService.getBook("Implementing Domain-driven Design", new Library("LibraryA", new Address("192.168.1.102", 3000)));
            libraryService.getAuthor("Vaughn", "Vernon");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
