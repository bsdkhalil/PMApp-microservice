package tn.esprit.examen.services;

import tn.esprit.examen.entities.Product;

public interface IProduitService {

    Product addProduit(Product e);
    public Boolean deleteProduit(String id);
    Product updateProduit(String id, Product e);


}
