package tn.esprit.examen.services;

import tn.esprit.examen.dto.ProductDto;
import tn.esprit.examen.entities.Produit;

import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit e);
    public Boolean deleteProduit(String id);
    List<Produit> getAllProdutcts();
    Produit updateProduit(String id,Produit e);

    Produit searchProductById(String id);

}
