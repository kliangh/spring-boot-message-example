package code.kliangh.messagesender.message.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class MqMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder messageBuilder = new StringBuilder("Hello RabbitMq");

        rabbitTemplate.convertAndSend(queue.getName(), messageBuilder.toString());
        System.out.println(MessageFormat.format(" [x] Message sent: {0}",
                                                messageBuilder.toString()));
    }
}
