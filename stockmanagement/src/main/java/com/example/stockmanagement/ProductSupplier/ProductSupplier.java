package com.example.stockmanagement.ProductSupplier;

import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.Supplier.Supplier;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"supplier_id", "product_id"})
})
public class ProductSupplier {

    @EmbeddedId
    private ProductSupplierId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(name = "supply_price")
    private int supplyPrice;

    @Column(name = "last_supplied_at")
    private LocalDateTime lastSuppliedAt;
}
