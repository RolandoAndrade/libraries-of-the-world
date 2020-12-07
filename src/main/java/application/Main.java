package application;

import application.views.Frame;
import client.application.LibraryService;
import client.infrastructure.RMIClientMiddleware;
import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.commands.LibraryACommandSet;
import shared.infrastructure.commands.Z39Commands;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new Frame("Librería A");

        /*LibraryService libraryService = new LibraryService(new FileRepository("src/main/resources/templates/library-template.xml"),
                new RMIClientMiddleware(new Library("Library A",
                        new Address("127.0.0.1", 3001)),
                        new ConsoleLogger()), new LibraryACommandSet(new Z39Commands()), new ConsoleLogger());
        try {
            libraryService.getBook("Implementing Domain-driven Design", new Library("LibraryA", new Address("192.168.1.101", 3000)));
            libraryService.getAuthor("Vaughn", "Vernon");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
