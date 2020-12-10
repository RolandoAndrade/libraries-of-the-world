package server.infrastructure;

import server.application.RemoteServerService;
import shared.domain.logging.LoggerService;
import shared.domain.requests.CommandSet;
import shared.domain.requests.IPManager;
import shared.infrastructure.common.FileRepository;
import shared.infrastructure.common.IPInterfaceManager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class GenericServer {
    public GenericServer(LoggerService logger, CommandSet libraryCommandSet, String[] args) throws Exception {
        int port = 3000;
        String filePath = ClassLoader.getSystemResource("templates/library-template.xml").getPath();
        if (args.length > 0) {
            port = Math.max(Integer.parseInt(args[0]), 2000);
            if (args.length > 1) {
                filePath = args[1];
            } else {
                logger.info("repository not defined, using default library-template.xml", "GenericServer", "");
            }
        } else {
            logger.info("port is not defined, using default 3000", "GenericServer", "");
            logger.info("repository not defined, using default library-template.xml", "GenericServer", "");
        }
        IPManager ipManager = new IPInterfaceManager();
        List<String> hosts = ipManager.listHosts();
        int selectedInterface = 0;
        if (hosts.size() > 1) {
            selectedInterface = selectInterface(hosts.size());
        }


        String route = ipManager.getRoute(port);
        System.setProperty("java.rmi.server.hostname", hosts.get(selectedInterface));
        RemoteServerService remoteServerService = new RemoteServerService(new FileRepository(filePath),
                libraryCommandSet, logger);
        Registry registry = LocateRegistry.createRegistry(port);
        logger.log("started server at ", "GenericServer", route);
        registry.rebind(route, remoteServerService);
    }

    int selectInterface(int length) {
        try {
            System.out.print("Multiple interfaces can be used, please select one: ");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if (num < length) {
                return num;
            }
            System.err.println("\nInterface out of range");
            return selectInterface(length);
        } catch (Exception e) {
            System.err.println("\nInvalid input, please select a number");
            return selectInterface(length);
        }
    }
}
