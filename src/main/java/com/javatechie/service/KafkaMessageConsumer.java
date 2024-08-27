package com.javatechie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageConsumer {

    @KafkaListener(topics = "javatechie-topic1",groupId = "jt-group1",
            topicPartitions = {@TopicPartition(topic = "javatechie-topic1", partitions = {"2"})})
    public void consume1(String message){
        log.info("consumer1 consumed the message {}",message );

    }
//
//    @KafkaListener(topics = "pramod-demo6",groupId = "jt-group-4")
//    public void consume2(String message){
//        log.info("consumer2 consumed the message {}",message );
//
//    }
//
//    @KafkaListener(topics = "pramod-demo6",groupId = "jt-group-4")
//    public void consume3(String message){
//        log.info("consumer3 consumed the message {}",message );
//
//    }
//
//    @KafkaListener(topics = "pramod-demo6",groupId = "jt-group-4")
//    public void consume4(String message){
//        log.info("consumer4 consumed the message {}",message );
//
//    }
}
