package pl.marcinzygmunt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConnectionConfiguration {

    private final RabbitConfigurationProperties rabbitConfigurationProperties;
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitConfigurationProperties.serverAddress());
        connectionFactory.setUsername(rabbitConfigurationProperties.serverUser());
        connectionFactory.setPassword(rabbitConfigurationProperties.serverPassword());
        return connectionFactory;
    }
}
