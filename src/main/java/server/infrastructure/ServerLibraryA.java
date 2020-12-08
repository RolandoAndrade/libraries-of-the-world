package server.infrastructure;

import shared.domain.logging.LoggerService;
import shared.infrastructure.commands.LibraryACommandSet;
import shared.infrastructure.commands.Z39Commands;
import shared.infrastructure.common.ConsoleLogger;

public class ServerLibraryA {
    public static void main(String[] args) {
        try {
            LoggerService loggerService = new ConsoleLogger();
            loggerService.log("Welcome to LibraryA server", "ServerLibraryA", "");
            GenericServer server = new GenericServer(loggerService,
                    new LibraryACommandSet(new Z39Commands()), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
