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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


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
        JFrame window = new Frame(Utilities.getConfiguration().getCurrentLibrary().getName());
/*
        LibraryService libraryService = new LibraryService(new FileRepository("src/main/resources/templates/library-template.xml"),
                new RMIClientMiddleware(new Library("Library A",
                        new Address("127.0.0.1", 3001)),
                        new ConsoleLogger()), new LibraryACommandSet(new Z39Commands()), new ConsoleLogger());
        try {
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormatter .parse("2020-12-08 21:05:30");

            //Now create the time and schedule it
            Timer timer = new Timer();

            //Use this if you want to execute it once
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        libraryService.getBook("Implementing Domain-driven Design", new Library("LibraryA", new Address("192.168.1.102", 3000)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, date);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


}
