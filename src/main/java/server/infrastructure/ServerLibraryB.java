package server.infrastructure;

import shared.domain.logging.LoggerService;
import shared.infrastructure.commands.LibraryBCommandSet;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.commands.Z39Commands;

public class ServerLibraryB {
    public static void main(String[] args) {
        try {
            LoggerService loggerService = new ConsoleLogger();
            loggerService.log("Welcome to LibraryB server", "ServerLibraryB", "");
            GenericServer server = new GenericServer(loggerService,
                    new LibraryBCommandSet(new Z39Commands()), args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
