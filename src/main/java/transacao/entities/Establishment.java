package transacao.entities;

public class Establishment {

    private String name;
    private String city;
    private String address;

    public Establishment(String name,
                         String city,
                         String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    @Override
    public String toString() {
        return "name='" + name
                + ", city='" + city
                + ", address='" + address;
    }
}

