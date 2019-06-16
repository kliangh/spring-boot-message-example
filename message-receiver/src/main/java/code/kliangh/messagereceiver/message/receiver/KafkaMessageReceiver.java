package code.kliangh.messagereceiver.message.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message) {
        LOGGER.info(String.format("Message Received!! [Message: %s]", message));
    }
}
