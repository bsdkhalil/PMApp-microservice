package tn.esprit.examen.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.dto.StockDTO;
import tn.esprit.examen.entities.Stock;
import tn.esprit.examen.services.IStockService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/stock")
public class StockController {
    IStockService stockService;
    ObjectMapper objectMapper;
    @GetMapping("/list")
    public List<StockDTO> getStocks() {
        List<Stock> stocks =stockService.getAllStocks();
        return stocks.stream().map(stock->objectMapper.convertValue(stock,StockDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/get/{stock_id}")
    public  StockDTO getSotckById(@PathVariable("stock_id") Long stock_id){
        return objectMapper.convertValue(stockService.searchStock(stock_id),StockDTO.class);
    }

    @DeleteMapping("/delete/stock/{idStock}")
    public Boolean deleteStock(@PathVariable("idStock") Long idStock) {
        return stockService.deleteStock(idStock);
    }

    @PostMapping("/add")
    public StockDTO addStock(@RequestBody StockDTO stcDto) {
        Stock stock = objectMapper.convertValue(stcDto,Stock.class);
        Stock addStock = stockService.addStock(stock);
        return objectMapper.convertValue(addStock,StockDTO.class);
    }
    @PatchMapping("/change/stock/{idStock}")
    public StockDTO changeStock(@PathVariable("idStock") Long idSotck, Stock p) {
        Stock udpatedStock =stockService.updateStock(idSotck,p);
        return objectMapper.convertValue(udpatedStock,StockDTO.class);

    }




}