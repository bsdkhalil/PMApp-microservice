package tn.esprit.examen.events;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.dto.ProductDto;
import tn.esprit.examen.services.IProduitService;

@Service
@RequiredArgsConstructor
public class ProductEventHandler {
    private final IProduitService productService;

    public void handleProductCreatedEvent(ProductDto productDto) {
        productService.addProduit(ProductDto.mapToProduct(productDto));
    }

    public void handleProductUpdatedEvent(ProductDto productDto) {
        productService.updateProduit(productDto._id(),ProductDto.mapToProduct(productDto));
    }

    public void handleProductDeletedEvent(String idProduct) {
        productService.deleteProduit(idProduct);
    }
}
