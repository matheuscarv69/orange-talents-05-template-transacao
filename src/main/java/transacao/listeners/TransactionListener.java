package transacao.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import transacao.commonKafka.kafkaRes.TransactionKafkaRes;
import transacao.entities.transaction.entities.Transaction;
import transacao.entities.transaction.repositories.TransactionRepository;

@Component
public class TransactionListener {

    @Autowired
    public TransactionRepository repository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionKafkaRes transactionKafkaRes) {
        System.out.println("-------------------Kafka Response-----------------------");
        System.out.println(transactionKafkaRes.toString());

        Transaction transaction = transactionKafkaRes.toModel();

        repository.save(transaction);
    }

//    Metodo "magico" do Tiago
//    @Bean
//    JsonMessageConverter jsonMessageConverter() {
//        return new JsonMessageConverter();
//    }
//
//    @KafkaListener(id = "my_transactions", topics = "transacoes")
//    void cats(EventoDeTransacao EventoDeTransacao) {
//        System.out.println("transaction = " + EventoDeTransacao.toString());
//    }

}
