package pl.marcinzygmunt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TopicExchangeConfiguration {
    private final RabbitConfigurationProperties rabbitConfigurationProperties;

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(rabbitConfigurationProperties.topicExchangeName());
    }

}
