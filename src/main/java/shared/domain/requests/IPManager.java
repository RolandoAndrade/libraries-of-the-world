package shared.domain.requests;


import java.util.List;

public interface IPManager {
    String getRoute(int port) throws Exception;

    List<String> listHosts() throws Exception;
}
