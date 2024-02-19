package pl.marcinzygmunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.marcinzygmunt.model.SampleMessage;
import pl.marcinzygmunt.service.RabbitProducer;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class SendController {

    private final RabbitProducer rabbitProducer;
    @PostMapping(value = "/direct")
    public String directProducer(@RequestBody SampleMessage message) {
        rabbitProducer.sendDirect(message);
        return String.format("Direct message sent to: %s",message.getRecipient().toUpperCase());
    }

    @PostMapping(value = "/topic")
    public String topicProducer(@RequestBody SampleMessage message) {
        rabbitProducer.sendTopic(message);
        return String.format("Topic message sent to: %s",message.getRecipient().toUpperCase());
    }

    @PostMapping(value = "/fanout")
    public String fanoutProducer(@RequestBody SampleMessage message) {
        rabbitProducer.sendFanout(message);
        return "Fanout message sent";
    }
}
