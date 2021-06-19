package transacao.entities.transaction.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    private String id;

    @NotNull
    @Column(nullable = false)
    private BigDecimal value;

    @OneToOne(cascade = CascadeType.MERGE)
    private Establishment establishment;

    @OneToOne(cascade = CascadeType.MERGE)
    private Card card;

    @PastOrPresent
    @NotNull
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

    // only hibernate
    @Deprecated
    public Transaction() {

    }

    public BigDecimal getValue() {
        return value;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public LocalDateTime getEffectiveIn() {
        return effectiveIn;
    }
}
