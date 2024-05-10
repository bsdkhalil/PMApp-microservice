package tn.esprit.examen.services;

import tn.esprit.examen.entities.Classe;

import java.util.List;

public interface IClasseService {

    Classe addClasse(Classe e);
    public Boolean deleteClasse(Long id);
    List<Classe> getAllClasses();
    Classe updateClasse(Long id, Classe s);
    Classe searchClasse(Long id);

}
