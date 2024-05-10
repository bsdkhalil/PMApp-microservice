package tn.esprit.examen.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tn.esprit.examen.dto.Event;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ProductEventHandler productEventHandler;
    private final String topic = "student-event-topic";
    @KafkaListener(topics = topic, groupId = "my-group")
    public void consume(ConsumerRecord<String,Event> consumerRecord) {

        Event event = consumerRecord.value();

        log.error("\n Consumed Event of type : {} \n published on topic at : {} \n Data value is : {}", event.type(), event.eventCreatedAt(), event.studentDto() );

        switch (consumerRecord.key()) {
            case "CREATED_STUDENT_EVENT":
                productEventHandler.handleStudentCreatedEvent(event.studentDto());
                break;
            case "UPDATE_STUDENT_EVENT":
                productEventHandler.handleStudentUpdatedEvent(event.studentDto());
                break;
            case "DELETE_STUDENT_EVENT":
                productEventHandler.handleStudentDeletedEvent(event.studentDto()._id());
                break;
            default:
                log.info("Event ignored");
                break;
        }

    }

}
