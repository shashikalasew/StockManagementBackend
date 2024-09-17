package com.example.stockmanagement.ProductSupplier;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSupplierDTO {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("supplier_id")
    private int supplierId;

    @JsonProperty("supply_price")
    private int supplyPrice;

    @JsonProperty("supply_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime supplyDate;
}
