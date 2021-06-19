package transacao.entities.transaction.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(nullable = false)
    private String address;

    public Establishment(String name,
                         String city,
                         String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    // only hibernate
    @Deprecated
    public Establishment() {

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

