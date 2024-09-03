package com.example.stockmanagement.Sales;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).orElse(null);
    }

    public Sale createSale(Sale sale) {
        sale.setSaleDate(java.time.LocalDateTime.now());
        return saleRepository.save(sale);
    }

    public Sale updateSale(int id, Sale saleDetails) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale != null) {
            sale.setProductId(saleDetails.getProductId());
            sale.setQuantitySold(saleDetails.getQuantitySold());
            sale.setSalePrice(saleDetails.getSalePrice());
            sale.setSaleDate(java.time.LocalDateTime.now());
            return saleRepository.save(sale);
        }
        return null;
    }

    public void deleteSale(int id) {
        saleRepository.deleteById(id);
    }
}
