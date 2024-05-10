package tn.esprit.examen.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tn.esprit.examen.clients.MSClassClient;
import tn.esprit.examen.dto.Event;
import tn.esprit.examen.dto.EventType;
import tn.esprit.examen.dto.StudentDto;
import tn.esprit.examen.dto.ClasseDTO;
import tn.esprit.examen.entities.Student;
import tn.esprit.examen.events.KafkaProducer;
import tn.esprit.examen.services.IStudentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    IStudentService produitService;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;
    MSClassClient msStockClient;
    KafkaProducer kafkaProducer;
    // http://localhost:8089/examen/projet/add-etudiant
    @GetMapping("/list")
    public List<StudentDto> getProduits(){
        return produitService.getAllStudents().stream().map(product->objectMapper.convertValue(product, StudentDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/get/{product_id}")
    public StudentDto getStudentById(@PathVariable("product_id") String productID){
        Student product =  produitService.searchStudentById(productID);
        ClasseDTO classe  = restTemplate.getForObject("http://localhost:8090/classe/get/{id}", ClasseDTO.class,product.getClass());
        //StockDTO s
        return StudentDto.builder()._id(product.get_id()).nom(product.getNom()).classe(classe).build();

    }
    @GetMapping("/get/openfeign/{product_id}")
    public StudentDto getStudentByIdWithOpenFeign(@PathVariable("product_id") String productID){
        Student product =  produitService.searchStudentById(productID);

        ClasseDTO classe  =msStockClient.findStock(product.getClasse()) ;
        //StockDTO s
        return StudentDto.builder()._id(product.get_id()).nom(product.getNom()).classe(classe).build();
        //return ;
    }

    @PostMapping("/add")
    public StudentDto addStudent(@RequestBody Student p) {
        //return objectMapper.convertValue(produitService.addProduit(p),ProductDto.class);
        Student product = produitService.addStudent(p);
        ClasseDTO classe  = restTemplate.getForObject("http://localhost:8090/classe/get/{id}", ClasseDTO.class,product.getClasse());
        StudentDto response = StudentDto.builder()._id(p.get_id()).nom(product.getNom()).classe(classe).build();
        kafkaProducer.produceEvent(new Event(EventType.CREATED_STUDENT_EVENT,response, LocalDateTime.now()));
        return response ;
    }

    @DeleteMapping("/delete/produit/{idProduit}")
    public Boolean deleteProduct(@PathVariable("idProduit") String idProduit){
        return produitService.deleteStudent(idProduit);
    }


    @PatchMapping("/change/produit/{idProduit}")
    public StudentDto changeProduit(@PathVariable("idProduit") String idProduit, Student p){
        Student updatedProduct = produitService.updateStudents(idProduit,p);
        ClasseDTO stock  = restTemplate.getForObject("http://localhost:8090/classe/get/{id}", ClasseDTO.class,updatedProduct.getClasse());
        StudentDto response = StudentDto.builder()._id(updatedProduct.get_id()).nom(updatedProduct.getNom()).classe(stock).build();
        kafkaProducer.produceEvent(new Event(EventType.CREATED_STUDENT_EVENT,response, LocalDateTime.now()));

        return response;

    }
}
