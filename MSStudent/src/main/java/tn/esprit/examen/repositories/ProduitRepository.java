package tn.esprit.examen.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.examen.entities.Student;

public interface ProduitRepository extends MongoRepository<Student,String> {
}
