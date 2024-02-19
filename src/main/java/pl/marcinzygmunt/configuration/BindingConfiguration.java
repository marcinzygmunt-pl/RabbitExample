package pl.marcinzygmunt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BindingConfiguration {
   private final RabbitConfigurationProperties rabbitConfigurationProperties;
    private final RabbitConnectionConfiguration rabbitConnectionConfiguration;
    /* QUEUES */
    @Bean(name = "alfa")
    Queue alfaQueue() {
        return new Queue(rabbitConfigurationProperties.alfaQueueName(), false);
    }
    @Bean(name = "beta")
    Queue betaQueue() {
        return new Queue(rabbitConfigurationProperties.betaQueueName(), false);
    }
    @Bean(name = "charlie")
    Queue charlieQueue() {
        return new Queue(rabbitConfigurationProperties.charlieQueueName(), false);
    }
    /* Fanout bindings */
    @Bean
    Binding bindAlfaToFanout(@Qualifier("alfa")Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    Binding bindBetaToFanout(@Qualifier("beta")Queue  secondQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(secondQueue).to(fanoutExchange);
    }

    /* Direct bindings */
    @Bean
    Binding bindAlfaToDirect(@Qualifier("alfa") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitConfigurationProperties.alfaRoutingKey());
    }

    @Bean
    Binding bindBetaToDirect(@Qualifier("beta") Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitConfigurationProperties.betaRoutingKey());
    }

    /* Topic bindings */
    @Bean
    Binding bindAlfaToTopic(@Qualifier("alfa") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitConfigurationProperties.alfaRoutingKey());
    }
    @Bean
    Binding bindBetaToTopic(@Qualifier("beta") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitConfigurationProperties.betaRoutingKey());
    }
    @Bean
    Binding bindCharlieToTopic(@Qualifier("charlie") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitConfigurationProperties.charlieRoutingKey());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name = "rabbitCustomTemplate")
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionConfiguration.connectionFactory());
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
