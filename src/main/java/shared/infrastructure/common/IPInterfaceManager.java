package shared.infrastructure.common;

import shared.domain.requests.IPManager;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IPInterfaceManager implements IPManager {

    private List<String> hosts;

    public IPInterfaceManager() throws SocketException {
        List<String> list = new ArrayList<>();
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        int id = 0;
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            // filters out 127.0.0.1 and inactive interfaces
            if (iface.isLoopback() || !iface.isUp())
                continue;

            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();

                // *EDIT*
                if (addr instanceof Inet6Address) continue;
                System.out.println("[ " + id + " ]: " + addr.getHostAddress());
                list.add(addr.getHostAddress());
                id++;
            }
            hosts = list;
        }
    }

    @Override
    public String getRoute(int port) throws SocketException {
        List<String> ips = listHosts();
        return "rmi://" + ips.get(ips.size() - 1) + ":" + port + "/books";
    }

    @Override
    public List<String> listHosts() throws SocketException {
        return hosts;
    }
}
