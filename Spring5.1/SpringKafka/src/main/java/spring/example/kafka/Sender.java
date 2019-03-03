package spring.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class Sender {

	private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.foo}")
    private String topic;

    public void send(String message){
        LOG.info("sending message='{}' to topic='{}'", message, topic);
        ListenableFuture<SendResult<String, String>> tracker=kafkaTemplate.send(topic, message);
        tracker.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> arg0) {
				LOG.info("successfully sent message='{}' to topic='{}'", message, topic);
			}

			@Override
			public void onFailure(Throwable ex) {
				LOG.info("failed sending message='{}' to topic='{}'", message, topic);
			}
        	
		}); 
    }
}
