package tn.esprit.examen.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.examen.dto.ClasseDTO;

@FeignClient(name="msstock",url = "http://localhost:8090/ms-stock/stock")
public interface MSClassClient {
    @GetMapping("/get/{id}")
    ClasseDTO findStock(@PathVariable("id") Long id);
}
