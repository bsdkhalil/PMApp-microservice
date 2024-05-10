package tn.esprit.examen.dto;
import java.time.LocalDateTime;

public record Event(EventType type, ProductDto productDto, LocalDateTime eventCreatedAt){}