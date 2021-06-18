package transacao.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private BigDecimal value;
    private Establishment establishment;
    private Card card;
    private LocalDateTime effectiveIn;

    public Transaction(String id,
                       BigDecimal value,
                       Establishment establishment,
                       Card card,
                       LocalDateTime effectiveIn) {


        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectiveIn = effectiveIn;
    }

    @Override
    public String toString() {
        return "id='" + id
                + ", value=" + value
                + ", establishment=" + establishment
                + ", card=" + card
                + ", effectiveIn=" + effectiveIn;
    }
}
