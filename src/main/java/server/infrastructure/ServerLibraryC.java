package server.infrastructure;

import shared.domain.logging.LoggerService;
import shared.infrastructure.commands.LibraryCCommandSet;
import shared.infrastructure.commands.Z39Commands;
import shared.infrastructure.common.ConsoleLogger;

public class ServerLibraryC {
    public static void main(String[] args) {
        try {
            LoggerService loggerService = new ConsoleLogger();
            loggerService.log("Welcome to LibraryC server", "ServerLibraryC", "");
            GenericServer server = new GenericServer(loggerService,
                    new LibraryCCommandSet(new Z39Commands()), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
