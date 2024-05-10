package tn.esprit.examen.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.dto.ClasseDTO;
import tn.esprit.examen.entities.Classe;
import tn.esprit.examen.services.IClasseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/classe")
public class ClasseController {
    IClasseService classeService;
    ObjectMapper objectMapper;
    @GetMapping("/list")
    public List<ClasseDTO> getClasses() {
        List<Classe> classes = classeService.getAllClasses();
        return classes.stream().map(classe ->objectMapper.convertValue(classe, ClasseDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/get/{classe_id}")
    public ClasseDTO getClasseById(@PathVariable("classe_id") Long classe_id){
        return objectMapper.convertValue(classeService.searchClasse(classe_id), ClasseDTO.class);
    }

    @DeleteMapping("/delete/stock/{idStock}")
    public Boolean deleteStock(@PathVariable("idStock") Long idStock) {
        return classeService.deleteClasse(idStock);
    }

    @PostMapping("/add")
    public ClasseDTO addStock(@RequestBody ClasseDTO stcDto) {
        Classe classe = objectMapper.convertValue(stcDto, Classe.class);
        Classe addClasse = classeService.addClasse(classe);
        return objectMapper.convertValue(addClasse, ClasseDTO.class);
    }
    @PatchMapping("/change/stock/{idStock}")
    public ClasseDTO changeStock(@PathVariable("idStock") Long idSotck, Classe p) {
        Classe udpatedClasse = classeService.updateClasse(idSotck,p);
        return objectMapper.convertValue(udpatedClasse, ClasseDTO.class);

    }




}