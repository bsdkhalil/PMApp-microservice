package tn.esprit.examen.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.esprit.examen.entities.Student;
import tn.esprit.examen.repositories.ProduitRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService implements IStudentService {

    ProduitRepository produitRepository;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;


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
    public List<Student> getAllStudents() {
        return produitRepository.findAll();
    }

    @Override
    public Student updateStudents(String id, Student p) {
        Student prod = produitRepository.findById(id).get();
        prod.setNom(p.getNom());
        produitRepository.save(prod);
        return prod;

    }

    @Override
    public Student searchStudentById(String id) {
        return  produitRepository.findById(id).get();
    }

}
