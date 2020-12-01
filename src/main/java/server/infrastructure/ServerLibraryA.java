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
            IPManager ipManager = new IPInterfaceManager();
            List<String> hosts = ipManager.listHosts();
            String route = ipManager.getRoute(4500);
            System.setProperty( "java.rmi.server.hostname", hosts.get(hosts.size()-1));

            LoggerService logger = new ConsoleLogger();
            RemoteServerService remoteServerService = new RemoteServerService(new FileRepository("src/main/resources/templates/library-template.xml"),
                    new LibraryACommandSet(new Z39Commands()), logger);
            Registry registry = LocateRegistry.createRegistry(4500);
            logger.log("started server at ", "ServerLibraryA", route);
            registry.rebind(route, remoteServerService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
