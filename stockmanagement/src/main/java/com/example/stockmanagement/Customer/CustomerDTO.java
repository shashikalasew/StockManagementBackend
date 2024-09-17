package com.example.stockmanagement.Customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerDTO {
    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("contact_information")
    private String contactInformation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
