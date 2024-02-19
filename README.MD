# Sample Rabbit MQ

Sample project with SpringBoot and RabbitMQ with Direct, Topic and Fanout Exchanges.

## How to use it ? 

- Run RabbitMQ docker from `/docker/docker-compose.yml` by using command `docker compose up -d` 

- Update settings in `application.yml`

- Run the application

- Send POST request 
  #### Direct - to queue based on routing key
    
     ```
          /api/direct:
        
          {
                  "message":"Sample text",
                  "recipient":"beta.two"
           }
     ```
  #### Topic - to one or multiple queues basing on key or keys wildcards
  
     ```
          /api/topic:  
        
          {
              "message":"Sample text",
              "recipient":"alfa.one"
          }
     ```
    
  #### Fanout - to all queues assigned to fanout exchange
    
  ```
      /api/fanout:
        
      {
      "message":"Sample text",
      }
     ```

## Want more ?
- [Get Started with RabbitMQ](https://rabbitmq.com/#getstarted)