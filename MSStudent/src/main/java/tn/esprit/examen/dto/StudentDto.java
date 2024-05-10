package tn.esprit.examen.dto;

import lombok.Builder;

@Builder
public record StudentDto(String _id, String nom, ClasseDTO classe) {
}
