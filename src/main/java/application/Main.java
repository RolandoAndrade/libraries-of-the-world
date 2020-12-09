package application;

import application.views.Frame;
import application.views.shared.Utilities;
import client.application.LibraryService;
import client.infrastructure.RMIClientMiddleware;
import com.google.gson.Gson;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import shared.domain.components.Address;
import shared.domain.components.Library;
import shared.infrastructure.commands.LibraryACommandSet;
import shared.infrastructure.commands.Z39Commands;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button[border].enable", false);
            UIManager.put("Button[border].toAll", false);
            UIManager.put("TextField[Line].inactiveColor", MaterialColors.GRAY_300);
            UIManager.put("TextField[Line].activeColor", MaterialColors.LIGHT_BLUE_400);
        } catch (Exception e) {

        }
        JFrame window = new Frame(Utilities.getConfiguration().getCurrentLibrary().getName());
*/
        LibraryService libraryService = new LibraryService(new FileRepository("src/main/resources/templates/library-template.xml"),
                new RMIClientMiddleware(new Library("Library A",
                        new Address("127.0.0.1", 3001)),
                        new ConsoleLogger()), new LibraryACommandSet(new Z39Commands()), new ConsoleLogger());
        try {
            libraryService.getBook("Implementing Domain-driven Design", new Library("LibraryA", new Address("192.168.1.102", 3000)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
