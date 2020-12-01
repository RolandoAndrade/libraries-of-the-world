package server.infrastructure;

import server.application.RemoteServerService;
import shared.domain.logging.LoggerService;
import shared.domain.requests.IPManager;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.common.IPInterfaceManager;
import shared.infrastructure.librarya.LibraryACommandSet;
import shared.infrastructure.z39.Z39Commands;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ServerLibraryA {
    public static void main(String[] args) {
        try {
            LoggerService loggerService = new ConsoleLogger();
            GenericServer server = new GenericServer(loggerService,
                    new LibraryACommandSet(new Z39Commands()), args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
