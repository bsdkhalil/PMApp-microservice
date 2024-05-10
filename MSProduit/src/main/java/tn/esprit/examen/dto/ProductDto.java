package tn.esprit.examen.dto;

import lombok.Builder;

@Builder
public record ProductDto(String _id, String nom,StockDTO stock) {
}
