package tn.esprit.examen.dto;

import lombok.Builder;
import tn.esprit.examen.entities.Product;

@Builder
public record ProductDto(String _id, String nom, StockDTO stock) {

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(productDto._id(), productDto.nom(),productDto.stock().id());
    }
}
