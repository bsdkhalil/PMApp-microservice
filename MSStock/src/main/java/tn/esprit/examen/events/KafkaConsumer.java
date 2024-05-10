package tn.esprit.examen.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tn.esprit.examen.dto.Event;
import tn.esprit.examen.dto.EventType;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ProductEventHandler productEventHandler;
    private final String topic = "product-event-topic";
    @KafkaListener(topics = topic, groupId = "my-group")
    public void consume(ConsumerRecord<String,Event> consumerRecord) {

        Event event = consumerRecord.value();

        log.error("\n Consumed Event of type : {} \n published on topic at : {} \n Data value is : {}", event.type(), event.eventCreatedAt(), event.productDto() );

        switch (consumerRecord.key()) {
            case "CREATED_PRODUCT_EVENT":
                productEventHandler.handleProductCreatedEvent(event.productDto());
                break;
            case "UPDATE_PRODUCT_EVENT":
                productEventHandler.handleProductUpdatedEvent(event.productDto());
                break;
            case "DELETE_PRODUCT_EVENT":
                productEventHandler.handleProductDeletedEvent(event.productDto()._id());
                break;
            default:
                log.info("Event ignored");
                break;
        }

    }

}
