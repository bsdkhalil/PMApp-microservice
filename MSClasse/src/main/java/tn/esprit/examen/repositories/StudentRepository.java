package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Student;

public interface StudentRepository extends JpaRepository<Student,String> {
}
