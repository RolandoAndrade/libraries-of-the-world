package shared.infrastructure.common;

import shared.domain.requests.IPManager;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPInterfaceManager implements IPManager {
    @Override
    public String getRoute(int port) throws SocketException {
        String ip = "";
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            // filters out 127.0.0.1 and inactive interfaces
            if (iface.isLoopback() || !iface.isUp())
                continue;

            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while(addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();

                // *EDIT*
                if (addr instanceof Inet6Address) continue;

                ip = addr.getHostAddress();
                System.out.println(iface.getDisplayName() + " " + ip);
            }
        }
        return "rmi://"+ip+":"+port+"/books";
    }
}
