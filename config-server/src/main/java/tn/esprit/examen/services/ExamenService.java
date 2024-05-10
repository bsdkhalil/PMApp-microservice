package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Etudiant;
import tn.esprit.examen.repositories.EtudiantRepository;

@Service
@AllArgsConstructor
@Slf4j
public class ExamenService implements IExamenService{

    EtudiantRepository etudiantRepository;




    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }
    @Scheduled(fixedDelay = 60000)
    void scheduler() {
        log.info("test");
    }
}
