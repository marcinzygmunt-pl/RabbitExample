package pl.marcinzygmunt.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "pl.marcinzygmunt.rabbit")
public record RabbitConfigurationProperties(
    String alfaQueueName,
    String betaQueueName,
    String charlieQueueName,
    String alfaRoutingKey,
    String betaRoutingKey,
    String charlieRoutingKey,

    String directExchangeName,
    String fanoutExchangeName,
    String topicExchangeName,
    String serverAddress,
    String serverUser,
    String serverPassword
){}
