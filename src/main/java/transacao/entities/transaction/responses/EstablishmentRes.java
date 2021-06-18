package transacao.entities.transaction.responses;

import transacao.entities.transaction.entities.Establishment;

public class EstablishmentRes {

    private String name;
    private String city;
    private String address;

    public EstablishmentRes(Establishment establishment) {
        this.name = establishment.getName();
        this.city = establishment.getCity();
        this.address = establishment.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
