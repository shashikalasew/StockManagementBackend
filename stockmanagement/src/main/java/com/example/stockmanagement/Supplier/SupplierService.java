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

    public Supplier addSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();

        supplier.setSupplierName(supplierDTO.getSupplierName());
        supplier.setContactName(supplierDTO.getContactName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setContactInformation(supplierDTO.getContactInformation());
        supplier.setAddress(supplierDTO.getAddress());

        supplier.setCreatedAt(java.time.LocalDateTime.now());
        supplier.setUpdatedAt(java.time.LocalDateTime.now());
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(int id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setSupplierName(supplierDTO.getSupplierName());
            supplier.setContactName(supplierDTO.getContactName());
            supplier.setEmail(supplierDTO.getEmail());
            supplier.setContactInformation(supplierDTO.getContactInformation());
            supplier.setAddress(supplierDTO.getAddress());

            supplier.setUpdatedAt(java.time.LocalDateTime.now());
            return supplierRepository.save(supplier);
        }
        return null;
    }

    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }
}
