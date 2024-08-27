package com.javatechie.service;

import com.javatechie.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaCustomerConsumer {

//    @KafkaListener(topics = "javatechie-topic", groupId = "jt-group")
//    public void consumeCustomerData(Customer customer){
//        log.info("consumer consumed the message {}",customer);
//    }

}
