import client.application.LibraryService;
import client.infrastructure.RMIClientMiddleware;
import shared.domain.components.Library;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.librarya.LibraryACommandSet;
import shared.infrastructure.z39.Z39Commands;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService(new FileRepository("/home/rolandoandrade/Descargas/libraries-of-the-world/src/main/resources/templates/library-template.xml"),
                new RMIClientMiddleware(new Library("Library A", "rmi://127.0.0.1:3000/Books"),
                        new ConsoleLogger()),new LibraryACommandSet(new Z39Commands()),new ConsoleLogger());

        try {
            libraryService.getBook("Domain-driven design", new Library("LibraryA", "rmi://127.0.0.1:3000/Books"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
