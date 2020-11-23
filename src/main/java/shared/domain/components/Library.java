package shared.domain.components;

public class Library {

    private final String name;
    private final Address address;

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
