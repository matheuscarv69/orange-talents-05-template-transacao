package transacao.entities;

public class Card {

    private String id;
    private String email;

    public Card(String id,
                String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "id='" + id
                + ", email='" + email;
    }
}
