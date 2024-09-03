package com.example.stockmanagement.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier addSupplier(Supplier supplier) {
        supplier.setCreatedAt(java.time.LocalDateTime.now());
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(int id, Supplier supplierDetails) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setSupplierName(supplierDetails.getSupplierName());
            supplier.setContactName(supplierDetails.getContactName());
            supplier.setEmail(supplierDetails.getEmail());
            supplier.setContactInformation(supplierDetails.getContactInformation());
            supplier.setAddress(supplierDetails.getAddress());
            supplier.setUpdatedAt(java.time.LocalDateTime.now());


            return supplierRepository.save(supplier);
        }
        return null;
    }

    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }
}
