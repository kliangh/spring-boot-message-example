package code.kliangh.messagesender.controller;

import code.kliangh.messagesender.message.producer.MqMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mq")
public class MessageQueueController {

    private MqMessageProducer mqMessageProducer;

    @Autowired
    public MessageQueueController(MqMessageProducer mqMessageProducer) {
        this.mqMessageProducer = mqMessageProducer;
    }

    @PostMapping(path = "/hello")
    public ResponseEntity produceMqMessage() {
        mqMessageProducer.send();
        return ResponseEntity.accepted().build();
    }
}
