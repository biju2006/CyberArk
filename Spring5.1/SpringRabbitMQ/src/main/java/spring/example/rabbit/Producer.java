package spring.example.rabbit;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Producer {
	 	
	@Value("${example.rabbitmq.exchange}")
	private String topicExchangeName;
	
	@Value("${example.rabbitmq.queue}")
    public String queueName;
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Value("${example.rabbitmq.routingkey}")
	private String routingKey;
    
    public void send(String message){
    	System.out.println("Sender - Sending message: "+message);
    	rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);
    }
}
