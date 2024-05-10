package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Classe;
import tn.esprit.examen.repositories.ClasseRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ClasseService implements IClasseService {
    ClasseRepository sr;
    @Override
    public Classe addClasse(Classe s) {
        return sr.save(s);
    }

    @Override
    public Boolean deleteClasse(Long id) {
        sr.deleteById(id);
        return true;
    }

    @Override
    public List<Classe> getAllClasses() {
        return sr.findAll();
    }

    @Override
    public Classe updateClasse(Long id, Classe s) {
        Classe classe = sr.findById(id).get();
        classe.setCode(s.getCode());
        sr.save(classe);
        return classe;
    }

    @Override
    public Classe searchClasse(Long id) {
        return sr.findById(id).get();
    }
}
