package server.infrastructure;

import server.application.RemoteServerService;
import shared.infrastructure.common.ConsoleLogger;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.librarya.LibraryACommandSet;
import shared.infrastructure.z39.Z39Commands;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            RemoteServerService remoteServerService = new RemoteServerService(new FileRepository("/home/rolandoandrade/Descargas/libraries-of-the-world/src/main/resources/templates/library-template.xml"),
                    new LibraryACommandSet(new Z39Commands()), new ConsoleLogger());
            Registry registry = LocateRegistry.createRegistry(3000);
            registry.rebind("rmi://127.0.0.1:3000/books", remoteServerService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
