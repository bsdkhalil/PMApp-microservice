package tn.esprit.examen.services;

import tn.esprit.examen.entities.Stock;

import java.util.List;

public interface IStockService {

    Stock addStock(Stock e);
    public Boolean deleteStock(Long id);
    List<Stock> getAllStocks();
    Stock updateStock(Long id,Stock s);
    Stock searchStock(Long id);

}
