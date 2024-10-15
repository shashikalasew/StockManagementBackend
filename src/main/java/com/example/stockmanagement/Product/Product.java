package com.example.stockmanagement.Product;

import com.example.stockmanagement.ProductSupplier.ProductSupplier;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private String description;
    private double price;
    private int quantityInStock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductSupplier> productSuppliers = new HashSet<>();

}

