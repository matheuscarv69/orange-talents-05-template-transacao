package transacao.entities.transaction.responses;

import transacao.entities.transaction.entities.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRes {

    private BigDecimal value;
    private EstablishmentRes establishment;
    private CardRes card;
    private LocalDateTime effectiveIn;

    public TransactionRes(Transaction transaction) {
        this.value = transaction.getValue();
        this.establishment = new EstablishmentRes(transaction.getEstablishment());
        this.card = new CardRes(transaction.getCard());
        this.effectiveIn = transaction.getEffectiveIn();
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentRes getEstablishment() {
        return establishment;
    }

    public CardRes getCard() {
        return card;
    }

    public LocalDateTime getEffectiveIn() {
        return effectiveIn;
    }
}
