package pl.marcinzygmunt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.marcinzygmunt.configuration.RabbitConfigurationProperties;
import pl.marcinzygmunt.model.SampleMessage;
@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitProducerImpl implements RabbitProducer{
    private final RabbitTemplate rabbitCustomTemplate;
    private final RabbitConfigurationProperties rabbitConfigurationProperties;
    @Override
    public void sendDirect(SampleMessage sampleMessage) {
        rabbitCustomTemplate.convertAndSend(
                rabbitConfigurationProperties.directExchangeName(),
                sampleMessage.getRecipient(),
                sampleMessage);
        log.info("Send to {}: {}", sampleMessage.getRecipient().toUpperCase(), sampleMessage.toString());
    }

    @Override
    public void sendTopic(SampleMessage sampleMessage) {
        rabbitCustomTemplate.convertAndSend(
                rabbitConfigurationProperties.topicExchangeName(),
                sampleMessage.getRecipient(),
                sampleMessage);
        log.info("Send to {}: {}", sampleMessage.getRecipient().toUpperCase(), sampleMessage.toString());
    }

    @Override
    public void sendFanout(SampleMessage sampleMessage) {
        rabbitCustomTemplate.convertAndSend(
                rabbitConfigurationProperties.fanoutExchangeName(),"",
                sampleMessage);
        log.info("Send to ALL: {}", sampleMessage.toString());
    }
}
