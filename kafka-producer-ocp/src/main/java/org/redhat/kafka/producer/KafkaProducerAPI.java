package org.redhat.kafka.producer;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.redhat.kafka.dto.KafkaProducerRequest;
import org.redhat.kafka.dto.KafkaProducerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demos/kafka/producer")
public class KafkaProducerAPI {
	
	@PostMapping("/putmessage")
    public static KafkaProducerResponse putMessage(@RequestBody KafkaProducerRequest request) throws Exception {
		System.out.println("******** KafkaProducerRequest Attributes=" + request);
		Properties properties = new Properties();
		
        properties.put("bootstrap.servers",request.getBootstrapServers()); //my-cluster-kafka-bootstrap-tag-it.apps.dev-ocp4.axis //my-cluster-kafka-bootstrap-amq-demo.apps.cluster-9b2c.9b2c.sandbox445.opentlc.com:443
        
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("security.protocol", "SSL");
        properties.put("ssl.truststore.location", "/deployments/keystore.jks");
        properties.put("ssl.truststore.password", "password"); 
        properties.put("batch.size", request.getBatchSize());
        properties.put("linger.ms", request.getLingerMs());
        properties.put("buffer.memory", request.getBufferMemory());
        
        //properties.put("batch.size", 30000); // 16384=default value
		//properties.put("linger.ms", 1);
		//properties.put("buffer.memory", 33554432);
		System.out.println("************ kafka Producer **********");
        KafkaProducerResponse response = new KafkaProducerResponse();
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        try{
        	
            for(long i = 1; i<=request.getMsgCount(); i++){
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++  "+i);
                kafkaProducer.send(new ProducerRecord<String, String>("my-topic", Long.toString(i), "test message - " + i ));
                System.out.println("___________________________________________________");
            }
            response.setCorrelationId(new Random().nextInt(Integer.MAX_VALUE)+1);
    		response.setStatus("SUCCESS");
    		response.setMessage("Message put successfully to kafka queue");
    		System.out.println("************* Message put successfully to kafka queue **************"+response);
        }catch (Exception e){
            e.printStackTrace();
            response.setCorrelationId(new Random().nextInt(Integer.MAX_VALUE)+1);
    		response.setStatus("FAILURE");
    		response.setMessage("Error putting message to kafka queue");
    		System.out.println("************* Error putting message to kafka queue ******************"+e);
        }finally {
            kafkaProducer.close();
        }
		
		return response;
    }

}
