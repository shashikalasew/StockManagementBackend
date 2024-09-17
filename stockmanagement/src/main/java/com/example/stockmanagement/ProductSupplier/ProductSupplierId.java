package com.example.stockmanagement.ProductSupplier;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductSupplierId implements Serializable {
    private  int productId;
    private int supplierId;

    public ProductSupplierId(int productId, int supplierId) {
        this.productId = productId;
        this.supplierId = supplierId;
    }
}
