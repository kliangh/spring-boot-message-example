package code.kliangh.messagesender.message.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class KafkaMessageProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessageProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        try {
            LOGGER.info(String.format("Message Sent!! [Topic: %s, Message: %s]", topic, message));
            kafkaTemplate.send(topic, message).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error(e.toString());
        }
    }
}
