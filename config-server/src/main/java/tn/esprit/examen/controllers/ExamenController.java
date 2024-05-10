package tn.esprit.examen.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entities.Etudiant;
import tn.esprit.examen.services.IExamenService;

@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ExamenController {

    IExamenService examenService;

    // http://localhost:8089/examen/projet/add-etudiant
    @PostMapping("/add-etudiant")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= examenService.addEtudiant(e);
        return etudiant;
    }
}
