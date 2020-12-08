package application;

import application.views.Frame;
import application.views.shared.Utilities;
import com.google.gson.Gson;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import shared.domain.components.Library;
import shared.domain.components.LibraryConfiguration;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        LibraryConfiguration configuration;
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button[border].enable", false);
            UIManager.put("Button[border].toAll", false);
            UIManager.put("TextField[Line].inactiveColor", MaterialColors.GRAY_300);
            UIManager.put("TextField[Line].activeColor", MaterialColors.LIGHT_BLUE_400);
        } catch (Exception e) {

        }
        JFrame window = new Frame(Utilities.getConfiguration().getCurrentLibrary().getName());

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
