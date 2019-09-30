package code.kliangh.workernode.task.worker;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RabbitListener(queues = "Rabbit")
public class RabbitMqWorker {

    @RabbitHandler
    public void receive(String message) {
        StringBuilder messageBuilder = new StringBuilder(message);

        System.out.println(MessageFormat.format(" [x] Message sent: {0}",
                                                messageBuilder.toString()));
    }
}
