package pl.marcinzygmunt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FanoutExchangeConfiguration {

    private  final RabbitConfigurationProperties rabbitConfigurationProperties;

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(rabbitConfigurationProperties.fanoutExchangeName());
    }


}
