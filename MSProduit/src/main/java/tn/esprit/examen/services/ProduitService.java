package tn.esprit.examen.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.examen.entities.Produit;
import tn.esprit.examen.repositories.ProduitRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitService implements IProduitService {

    ProduitRepository produitRepository;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;


    @Override
    public Produit addProduit(Produit e) {
        return produitRepository.save(e);
    }
    @Override
    public Boolean deleteProduit(String id) {
        produitRepository.deleteById(id);
        return true ;
    }

    @Override
    public List<Produit> getAllProdutcts() {
        return produitRepository.findAll();
    }

    @Override
    public Produit updateProduit(String id, Produit p) {
        Produit prod = produitRepository.findById(id).get();
        prod.setNom(p.getNom());
        produitRepository.save(prod);
        return prod;

    }

    @Override
    public Produit searchProductById(String id) {
        return  produitRepository.findById(id).get();
    }

}
