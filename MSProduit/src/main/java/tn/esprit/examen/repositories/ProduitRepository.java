package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.examen.entities.Produit;

public interface ProduitRepository extends MongoRepository<Produit,String> {
}
