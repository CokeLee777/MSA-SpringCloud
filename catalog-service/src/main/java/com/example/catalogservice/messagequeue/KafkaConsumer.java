package com.example.catalogservice.messagequeue;

import com.example.catalogservice.domain.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KafkaConsumer {

    private final CatalogRepository repository;

    @KafkaListener(topics = "example-catalog-topic")
    @Transactional
    public void updateQuantity(String kafkaMessage){
        log.info("Kafka Message={}", kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch(JsonProcessingException ex){
            ex.printStackTrace();
        }

        CatalogEntity catalogEntity = repository.findByProductId((String) map.get("productId"));
        if(catalogEntity != null){
            catalogEntity.setStock(catalogEntity.getStock() - (Integer) map.get("quantity"));
//            repository.save(catalogEntity);
        }
    }
}
