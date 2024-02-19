package pl.marcinzygmunt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DirectExchangeConfiguration {

    private final RabbitConfigurationProperties rabbitConfigurationProperties;

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(rabbitConfigurationProperties.directExchangeName());
    }

}
