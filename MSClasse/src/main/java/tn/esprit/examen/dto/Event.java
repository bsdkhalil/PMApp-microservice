package tn.esprit.examen.dto;
import java.time.LocalDateTime;

public record Event(EventType type, StudentDto studentDto, LocalDateTime eventCreatedAt){}