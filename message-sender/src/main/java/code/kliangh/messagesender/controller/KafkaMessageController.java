package code.kliangh.messagesender.controller;

import code.kliangh.messagesender.message.producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaMessageController {

    private KafkaMessageProducer kafkaMessageProducer;

    @Autowired
    public KafkaMessageController(KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    @PostMapping(path = "/{topic}")
    public ResponseEntity produceKafkaMessage(@PathVariable String topic,
                                              @RequestBody String requestBody) {
        kafkaMessageProducer.sendMessage(topic, requestBody);
        return ResponseEntity.ok().build();
    }
}
