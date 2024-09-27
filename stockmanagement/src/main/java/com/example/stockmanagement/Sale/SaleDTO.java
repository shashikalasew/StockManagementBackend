package com.example.stockmanagement.Sale;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleDTO {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("quantity_sold")
    private int quantitySold;

    @JsonProperty("sale_price")
    private double salePrice;

    @JsonProperty("sale_date")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDateTime saleDate;

}
