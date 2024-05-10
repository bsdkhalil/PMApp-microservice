package tn.esprit.examen.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tn.esprit.examen.dto.Event;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, Event> kafkaTemplate;
    private String topic = "student-event-topic";

    public void produceEvent(Event studentEvent) {
        kafkaTemplate.send(this.topic, studentEvent.type().toString() , studentEvent);
    }

}
