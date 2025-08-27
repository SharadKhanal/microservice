package com.question.configration;

import com.question.constant.KafkaTopicConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic1(){
        return TopicBuilder
                .name(KafkaTopicConstant.LOCATION_TOPIC_NAME)
//                .partitions()
//                .replicas()
                .build();
    }
}
