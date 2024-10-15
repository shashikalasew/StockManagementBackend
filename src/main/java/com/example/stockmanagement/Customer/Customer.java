package com.example.stockmanagement.Customer;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;

    @Column(unique = true)
    private String email;

    private String contactInformation;
    private LocalDateTime createdAt;

}
