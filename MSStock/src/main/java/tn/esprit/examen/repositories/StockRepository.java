package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
