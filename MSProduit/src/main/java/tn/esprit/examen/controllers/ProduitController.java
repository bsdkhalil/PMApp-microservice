package tn.esprit.examen.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tn.esprit.examen.clients.MSStockClient;
import tn.esprit.examen.dto.Event;
import tn.esprit.examen.dto.EventType;
import tn.esprit.examen.dto.ProductDto;
import tn.esprit.examen.dto.StockDTO;
import tn.esprit.examen.entities.Produit;
import tn.esprit.examen.events.KafkaProducer;
import tn.esprit.examen.services.IProduitService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProduitController {

    IProduitService produitService;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;
    MSStockClient msStockClient;
    KafkaProducer kafkaProducer;
    // http://localhost:8089/examen/projet/add-etudiant
    @GetMapping("/list")
    public List<ProductDto> getProduits(){
        return produitService.getAllProdutcts().stream().map(product->objectMapper.convertValue(product, ProductDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/get/{product_id}")
    public ProductDto getProductById(@PathVariable("product_id") String productID){
        Produit product =  produitService.searchProductById(productID);
        StockDTO stock  = restTemplate.getForObject("http://localhost:8090/stock/get/{id}",StockDTO.class,product.getStock());
        //StockDTO s
        return ProductDto.builder()._id(product.get_id()).nom(product.getNom()).stock(stock).build();

    }
    @GetMapping("/get/openfeign/{product_id}")
    public ProductDto getProductByIdWithOpenFeign(@PathVariable("product_id") String productID){
        Produit product =  produitService.searchProductById(productID);

        StockDTO stock  =msStockClient.findStock(product.getStock()) ;
        //StockDTO s
        return ProductDto.builder()._id(product.get_id()).nom(product.getNom()).stock(stock).build();
        //return ;
    }

    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody Produit p) {
        //return objectMapper.convertValue(produitService.addProduit(p),ProductDto.class);
        Produit product = produitService.addProduit(p);
        StockDTO stock  = restTemplate.getForObject("http://localhost:8090/stock/get/{id}",StockDTO.class,product.getStock());
        ProductDto response = ProductDto.builder()._id(p.get_id()).nom(product.getNom()).stock(stock).build();
        kafkaProducer.produceEvent(new Event(EventType.CREATED_PRODUCT_EVENT,response, LocalDateTime.now()));
        return response ;
    }

    @DeleteMapping("/delete/produit/{idProduit}")
    public Boolean deleteProduct(@PathVariable("idProduit") String idProduit){
        return produitService.deleteProduit(idProduit);
    }


    @PatchMapping("/change/produit/{idProduit}")
    public ProductDto changeProduit(@PathVariable("idProduit") String idProduit, Produit p){
        Produit updatedProduct = produitService.updateProduit(idProduit,p);
        StockDTO stock  = restTemplate.getForObject("http://localhost:8090/stock/get/{id}",StockDTO.class,updatedProduct.getStock());
        ProductDto response = ProductDto.builder()._id(updatedProduct.get_id()).nom(updatedProduct.getNom()).stock(stock).build();
        kafkaProducer.produceEvent(new Event(EventType.UPDATE_PRODUCT_EVENT,response, LocalDateTime.now()));

        return response;

    }
}
