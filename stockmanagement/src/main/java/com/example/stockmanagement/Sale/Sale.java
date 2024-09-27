package com.example.stockmanagement.Sale;


import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id" )
    private User user;
    private int quantitySold;
    private double salePrice;
    private LocalDateTime saleDate;


}
