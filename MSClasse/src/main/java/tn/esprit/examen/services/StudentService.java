package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Student;
import tn.esprit.examen.repositories.StudentRepository;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService implements IStudentService {
    StudentRepository produitRepository;
    @Override
    public Student addStudent(Student e) {
        return produitRepository.save(e);
    }
    @Override
    public Boolean deleteStudent(String id) {
        produitRepository.deleteById(id);
        return true ;
    }
    @Override
    public Student updateStudent(String id, Student p) {
        Student prod = produitRepository.findById(id).get();
        prod.setNom(p.getNom());
        produitRepository.save(prod);
        return prod;

    }

}
