package transacao.entities.transaction.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Card {

    @Id
    private String id;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    public Card(String id,
                String email) {
        this.id = id;
        this.email = email;
    }

    // only hibernate
    @Deprecated
    public Card() {
    }

    @Override
    public String toString() {
        return "id='" + id
                + ", email='" + email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
