package application;

import application.infrastructure.GenericClient;
import application.views.Frame;
import application.views.shared.Utilities;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import shared.domain.components.LibraryConfiguration;
import shared.domain.requests.CommandSet;
import shared.infrastructure.commands.LibraryACommandSet;
import shared.infrastructure.commands.LibraryBCommandSet;
import shared.infrastructure.commands.LibraryCCommandSet;
import shared.infrastructure.commands.Z39Commands;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.DualLogger;
import shared.infrastructure.common.FileLogger;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button[border].enable", false);
            UIManager.put("Button[border].toAll", false);
            UIManager.put("TextField[Line].inactiveColor", MaterialColors.GRAY_300);
            UIManager.put("TextField[Line].activeColor", MaterialColors.LIGHT_BLUE_400);
        } catch (Exception e) {

        }
        LibraryConfiguration configuration = Utilities.getConfiguration();
        GenericClient client = new GenericClient(new DualLogger(), getCommandSet(configuration.getCurrentLibrary().getName()), args);
        JFrame window = new Frame(configuration.getCurrentLibrary().getName());
    }


    private static CommandSet getCommandSet(String library){
        switch (library){
            case "Librería A": return new LibraryACommandSet(new Z39Commands());
            case "Librería B": return new LibraryBCommandSet(new Z39Commands());
            default: return new LibraryCCommandSet(new Z39Commands());
        }
    }

}
