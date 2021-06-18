package transacao.commonKafka.kafkaRes;

import transacao.entities.Establishment;

public class EstablishmentKafkaRes {

    private String nome;
    private String cidade;
    private String endereco;

    public Establishment toModel(){
        return new Establishment(nome, cidade, endereco);
    }

    // Sem os getters o JsonDeserializer do kafka nao consegue deserializar

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "nome='" + nome
                + ", cidade='" + cidade
                + ", endereco='" + endereco;
    }
}
