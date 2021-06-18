package transacao.entities.transaction.responses;

import transacao.entities.transaction.entities.Card;

public class CardRes {

    private String id;
    private String email;

    public CardRes(Card card) {
        this.id = card.getId();
        this.email = card.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
