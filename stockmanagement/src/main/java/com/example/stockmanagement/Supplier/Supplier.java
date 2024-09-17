package com.example.stockmanagement.Supplier;

import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.ProductSupplier.ProductSupplier;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String supplierName;
    private String contactName;
    private String email;
    private String contactInformation;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<ProductSupplier> productSuppliers = new HashSet<>();
}
