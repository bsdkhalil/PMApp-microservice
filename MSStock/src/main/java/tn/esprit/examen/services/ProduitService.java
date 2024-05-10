package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Product;
import tn.esprit.examen.repositories.ProductRepository;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitService implements IProduitService {
    ProductRepository produitRepository;
    @Override
    public Product addProduit(Product e) {
        return produitRepository.save(e);
    }
    @Override
    public Boolean deleteProduit(String id) {
        produitRepository.deleteById(id);
        return true ;
    }
    @Override
    public Product updateProduit(String id, Product p) {
        Product prod = produitRepository.findById(id).get();
        prod.setNom(p.getNom());
        produitRepository.save(prod);
        return prod;

    }

}
