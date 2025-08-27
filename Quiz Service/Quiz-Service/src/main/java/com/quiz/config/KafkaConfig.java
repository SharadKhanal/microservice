package com.quiz.config;

import com.quiz.constants.KafkaTopicConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
     @KafkaListener(topics= KafkaTopicConstant.LOCATION_TOPIC_NAME,groupId = KafkaTopicConstant.GROUP_ID)
    public void updatedLocation(String value){
         System.out.println(value);
    }
}
