package transacao.commonKafka.kafkaRes;

import transacao.entities.transaction.entities.Card;

public class CardKafkaRes {


    private String id;
    private String email;

    public Card toModel() {
        return new Card(id, email);
    }

    // Sem os getters o JsonDeserializer do kafka nao consegue deserializar

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "id='" + id
                + ", email='" + email;
    }

}
