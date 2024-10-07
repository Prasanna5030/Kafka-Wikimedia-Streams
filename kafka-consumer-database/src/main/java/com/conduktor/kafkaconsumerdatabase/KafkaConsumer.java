package com.conduktor.kafkaconsumerdatabase;

import com.conduktor.kafkaconsumerdatabase.model.WikimediaData;
import com.conduktor.kafkaconsumerdatabase.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Value("${spring.kafka.topic.name}")
   private String topic;

    @KafkaListener(topics = "wikimedia-topic", groupId = "myGroup")
    public void consume(String messageEvent){

        LOGGER.info(String.format("Event Message Recieved ->  %s" , messageEvent));

        WikimediaData data= new WikimediaData();
        data.setWikimediaEvent(messageEvent);

        wikimediaDataRepository.save(data);
    }

}
