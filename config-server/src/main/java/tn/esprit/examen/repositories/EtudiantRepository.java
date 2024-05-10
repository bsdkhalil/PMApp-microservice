package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
