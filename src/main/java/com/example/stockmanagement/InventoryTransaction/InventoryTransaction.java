package com.example.stockmanagement.InventoryTransaction;

import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id" )
    private User user;

    private int quantity;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    private LocalDateTime transactionDate;




}
