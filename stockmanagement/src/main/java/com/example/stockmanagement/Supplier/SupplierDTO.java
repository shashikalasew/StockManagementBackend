package com.example.stockmanagement.Supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SupplierDTO {

    @JsonProperty("supplier_name")
    private String supplierName;

    @JsonProperty("contact_name")
    private String contactName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("contact_information")
    private String contactInformation;

    @JsonProperty("address")
    private String address;
}
