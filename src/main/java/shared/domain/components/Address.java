package shared.domain.components;

public class Address {
    private final String url;
    private final int port;

    public Address(String url, int port){
        this.url = url;
        this.port = port;
    }

    public String getAddress(){
        return "rmi://" + this.url + ":" + this.port + "/books";
    }


    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "Address{" +
                "url='" + url + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
