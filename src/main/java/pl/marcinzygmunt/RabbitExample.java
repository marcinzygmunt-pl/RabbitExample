package pl.marcinzygmunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RabbitExample {
    public static void main(String[] args) {
        SpringApplication.run(RabbitExample.class, args);
    }
}