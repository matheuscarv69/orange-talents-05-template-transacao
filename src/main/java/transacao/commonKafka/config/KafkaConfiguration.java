package transacao.commonKafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import transacao.commonKafka.kafkaRes.TransactionKafkaRes;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de configuracao de um Consumer do Kafka
 * */
@Configuration
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    /**
     * Metodo do tipo de pattern Factory,
     * Ele serve como um fabrica de Consumers.
     * Define qual o desserializador da chave e do evento(mensagem) e
     * Define quais propriedades esse consumer deve ter
     * */
    @Bean
    public ConsumerFactory<String, TransactionKafkaRes> transactionConsumerFactory() {
        StringDeserializer stringDeserializer = new StringDeserializer();
        JsonDeserializer<TransactionKafkaRes> jsonDeserializer = new JsonDeserializer<>(TransactionKafkaRes.class, false);

        return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), stringDeserializer, jsonDeserializer);
    }

    /**
     * Cadastra o listener para receber os eventos(mensagens) recebidos,
     * isso eh feito usando o setConsumerFactory recebendo o transactionConsumerFactory
     * nosso metodo de criacao de consumers
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransactionKafkaRes> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TransactionKafkaRes> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(transactionConsumerFactory());

        return factory;
    }

    /**
     * Metodo para adicionar as propriedades ao consumer
     * */
    public Map<String, Object> consumerConfigurations() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());

        return properties;
    }


}
