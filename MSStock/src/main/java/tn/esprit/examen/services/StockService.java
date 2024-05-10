package tn.esprit.examen.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Stock;
import tn.esprit.examen.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StockService implements IStockService{
    StockRepository sr;
    @Override
    public Stock addStock(Stock s) {
        return sr.save(s);
    }

    @Override
    public Boolean deleteStock(Long id) {
        sr.deleteById(id);
        return true;
    }

    @Override
    public List<Stock> getAllStocks() {
        return sr.findAll();
    }

    @Override
    public Stock updateStock(Long id, Stock s) {
        Stock stock = sr.findById(id).get();
        stock.setZone(s.getZone());
        sr.save(stock);
        return stock;
    }

    @Override
    public Stock searchStock(Long id) {
        return sr.findById(id).get();
    }
}
