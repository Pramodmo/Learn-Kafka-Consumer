package com.javatechie;

import com.javatechie.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
class LearnKafkaConsumerApplicationTests {

	@Container
	static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));

	@DynamicPropertySource
	public static void initKafkaProperties(DynamicPropertyRegistry registry){
		registry.add("spring.kafka.bootstrap-servers",kafka::getBootstrapServers);
	}

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	public void testConsumeCustomerData(){
	 log.info("testConsumeCustomerData method execution started...");
     kafkaTemplate.send("pramod-demo9-Json",new Customer(2,"test-name","test@gmail.com","783465983"));
	 await().pollInterval(Duration.ofSeconds(3)).atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {});
		log.info("testConsumeCustomerData method execution ended...");
	}

}
