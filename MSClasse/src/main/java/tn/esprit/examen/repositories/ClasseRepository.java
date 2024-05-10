package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
}
