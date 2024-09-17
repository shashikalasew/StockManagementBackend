package com.example.stockmanagement.ProductSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-suppliers")
public class ProductSupplierController {

    @Autowired
    private ProductSupplierService productSupplierService;

    @GetMapping
    public List<ProductSupplier> getAllProductSuppliers() {
        return productSupplierService.getAllProductSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSupplier> getProductSupplierById(@PathVariable int id) {
        ProductSupplier productSupplier = productSupplierService.getProductSupplierById(id);
        if (productSupplier != null) {
            return ResponseEntity.ok(productSupplier);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProductSupplier addProductSupplier(@RequestBody ProductSupplierDTO productSupplierDTO) {
        return productSupplierService.addProductSupplier(productSupplierDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductSupplier> updateProductSupplier(@PathVariable int id, @RequestBody ProductSupplierDTO productSupplierDTO) {
        ProductSupplier productSupplier = productSupplierService.updateProductSupplier(id, productSupplierDTO);
        if (productSupplier != null) {
            return ResponseEntity.ok(productSupplier);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductSupplier(@PathVariable int id) {
        productSupplierService.deleteProductSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
