package transacao.commonKafka.kafkaRes;

import transacao.entities.transaction.entities.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Classe de resposta que o kafka envia pelo topico
 * configurado
 * */
public class TransactionKafkaRes {

    private String id;

    private BigDecimal valor;

    private EstablishmentKafkaRes estabelecimento;

    private CardKafkaRes cartao;

    private LocalDateTime efetivadaEm;

    public Transaction toModel() {
        return new Transaction(id,
                valor,
                estabelecimento.toModel(),
                cartao.toModel(),
                efetivadaEm
        );
    }

    // Sem os getters o JsonDeserializer do kafka nao consegue deserializar

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstablishmentKafkaRes getEstabelecimento() {
        return estabelecimento;
    }

    public CardKafkaRes getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "id: " + id
                + ", valor: " + valor
                + ", estabelecimento: " + estabelecimento
                + ", cartao: " + cartao
                + ", efetivadaEm: " + efetivadaEm;
    }
}
