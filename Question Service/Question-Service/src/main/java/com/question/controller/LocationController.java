package com.question.controller;

import com.question.kafka.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final KafkaService kafkaService;

    public LocationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        // for sending many messages
//        for( int i =0; i < 10000; i++){
//            kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + " " + ")");
//        }
        kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + " " + ")");
        return new ResponseEntity<>(Map.of("message","Location Updated"), HttpStatus.OK);
    }
}
