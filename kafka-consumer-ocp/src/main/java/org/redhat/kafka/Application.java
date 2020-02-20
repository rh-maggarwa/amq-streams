package org.redhat.kafka;

import org.redhat.kafka.consumer.KafkaConsumerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
		KafkaConsumerController.getMessage();
	}
}
