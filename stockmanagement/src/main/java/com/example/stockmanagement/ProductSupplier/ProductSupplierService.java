package com.example.stockmanagement.ProductSupplier;

import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.Product.ProductRepository;
import com.example.stockmanagement.Supplier.Supplier;
import com.example.stockmanagement.Supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductSupplierService {

@Autowired
private ProductSupplierRepository productSupplierRepository;

@Autowired
private ProductRepository productRepository;

@Autowired
private SupplierRepository supplierRepository;

public List<ProductSupplier> getAllProductSuppliers(){
    return productSupplierRepository.findAll();
}

public ProductSupplier getProductSupplierById(int id) {
    return productSupplierRepository.findById(id).orElse(null);
}


    public ProductSupplier addProductSupplier(ProductSupplierDTO productSupplierDTO) {

        ProductSupplier productSupplier = new ProductSupplier();

        ProductSupplierId productSupplierId = new ProductSupplierId(productSupplierDTO.getProductId(), productSupplierDTO.getSupplierId());

        productSupplier.setId(productSupplierId);

        Product product = productRepository.findById(productSupplierDTO.getProductId()).orElseThrow();
        productSupplier.setProduct(product);

        Supplier supplier = supplierRepository.findById(productSupplierDTO.getSupplierId()).orElseThrow();
        productSupplier.setSupplier(supplier);

        productSupplier.setSupplyPrice(productSupplierDTO.getSupplyPrice());

        productSupplier.setLastSuppliedAt(java.time.LocalDateTime.now());
        return productSupplierRepository.save(productSupplier);
    }

    public ProductSupplier updateProductSupplier(int id, ProductSupplierDTO productSupplierDTO) {
        ProductSupplier productSupplier = productSupplierRepository.findById(id).orElse(null);
        if (productSupplier != null) {

            Product product = productRepository.findById(productSupplierDTO.getProductId()).orElseThrow();
            productSupplier.setProduct(product);

            Supplier supplier = supplierRepository.findById(productSupplierDTO.getSupplierId()).orElseThrow();
            productSupplier.setSupplier(supplier);

            productSupplier.setSupplyPrice(productSupplierDTO.getSupplyPrice());

            productSupplier.setLastSuppliedAt(productSupplierDTO.getSupplyDate());
            return productSupplierRepository.save(productSupplier);
        }
        return null;
    }

    public void deleteProductSupplier(int id) {
        productSupplierRepository.deleteById(id);
    }

}
