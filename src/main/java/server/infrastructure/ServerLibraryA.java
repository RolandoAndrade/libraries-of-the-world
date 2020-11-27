package server.infrastructure;

import server.application.RemoteServerService;
import shared.domain.logging.LoggerService;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.common.IPInterfaceManager;
import shared.infrastructure.librarya.LibraryACommandSet;
import shared.infrastructure.z39.Z39Commands;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerLibraryA {
    public static void main(String[] args) {
        try {
            LoggerService logger = new ConsoleLogger();
            RemoteServerService remoteServerService = new RemoteServerService(new FileRepository("src/main/resources/templates/library-template.xml"),
                    new LibraryACommandSet(new Z39Commands()), logger);
            Registry registry = LocateRegistry.createRegistry(3000);
            String route = new IPInterfaceManager().getRoute(3000);
            logger.log("started server at ", "ServerLibraryA", route);
            Naming.rebind(route, remoteServerService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
