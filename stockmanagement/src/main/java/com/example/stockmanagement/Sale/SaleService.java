package com.example.stockmanagement.Sale;


import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.Product.ProductRepository;
import com.example.stockmanagement.User.User;
import com.example.stockmanagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(int id) {
        return saleRepository.findById(id).orElse(null);
    }


    public Sale createSale(SaleDTO saleDTO) {
        Sale sale = new Sale();
        Product product = productRepository.findById(saleDTO.getProductId()).orElseThrow();
        sale.setProduct(product);

        User user = userRepository.findById(saleDTO.getUserId()).orElseThrow();
        sale.setUser(user);

        sale.setSalePrice(saleDTO.getSalePrice());
        sale.setQuantitySold(saleDTO.getQuantitySold());
        sale.setSaleDate(java.time.LocalDateTime.now());
        return saleRepository.save(sale);
    }

    public Sale updateSale(int id, SaleDTO saleDTO) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale != null) {
            Product product = productRepository.findById(saleDTO.getProductId()).orElseThrow();
            sale.setProduct(product);

            User user = userRepository.findById(saleDTO.getUserId()).orElseThrow();
            sale.setUser(user);

            sale.setQuantitySold(saleDTO.getQuantitySold());
            sale.setSalePrice(saleDTO.getSalePrice());
            sale.setSaleDate(saleDTO.getSaleDate());
            return saleRepository.save(sale);
        }
        return null;
    }

    public void deleteSale(int id) {
        saleRepository.deleteById(id);
    }
}
