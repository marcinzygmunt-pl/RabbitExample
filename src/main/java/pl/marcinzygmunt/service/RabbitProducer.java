package pl.marcinzygmunt.service;

import pl.marcinzygmunt.model.SampleMessage;

public interface RabbitProducer {

    void sendDirect(SampleMessage sampleMessage);

    void sendTopic(SampleMessage sampleMessage);

    void sendFanout(SampleMessage sampleMessage);
}
