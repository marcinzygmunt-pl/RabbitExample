package pl.marcinzygmunt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcinzygmunt.configuration.RabbitConfigurationProperties;
import pl.marcinzygmunt.model.SampleMessage;

@Slf4j
@Service
public class ListenerServices {

    @Autowired
    RabbitConfigurationProperties rabbitConfigurationProperties;
    @RabbitListener(queues = "${pl.marcinzygmunt.rabbit.alfa-queue-name}")
    public void alfaListener(SampleMessage sampleMessage) {
        log.info("#ALFA MESSAGE RECIVED: {}", sampleMessage.getMessage());
    }

    @RabbitListener(queues = "${pl.marcinzygmunt.rabbit.beta-queue-name}")
    public void betaListener(SampleMessage sampleMessage) {
        log.info("#BETA MESSAGE RECIVED: {}", sampleMessage.getMessage());
    }

    @RabbitListener(queues = "${pl.marcinzygmunt.rabbit.charlie-queue-name}")
    public void charlieListener(SampleMessage sampleMessage) {
        log.info("#CHARLIE MESSAGE RECIVED: {}", sampleMessage.getMessage());
    }

}
