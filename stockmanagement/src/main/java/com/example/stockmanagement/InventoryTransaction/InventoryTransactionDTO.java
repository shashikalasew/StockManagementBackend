package com.example.stockmanagement.InventoryTransaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class InventoryTransactionDTO {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("user_id")
    private int userId;

    private int quantity;

    @JsonProperty("transaction_type")
    private TransactionType transactionType;

    @JsonProperty("transaction_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDateTime transactionDate;

}
