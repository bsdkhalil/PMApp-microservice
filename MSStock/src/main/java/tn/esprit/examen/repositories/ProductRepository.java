package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Product;

public interface ProductRepository extends JpaRepository<Product,String> {
}
