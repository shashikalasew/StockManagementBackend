package com.example.stockmanagement.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryTransactionService {

    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    public List<InventoryTransaction> getAllTransactions() {
        return inventoryTransactionRepository.findAll();
    }

    public InventoryTransaction getTransactionById(int id) {
        return inventoryTransactionRepository.findById(id).orElse(null);
    }

    public InventoryTransaction addTransaction(InventoryTransaction transaction) {
        transaction.setTransactionDate(java.time.LocalDateTime.now());
        return inventoryTransactionRepository.save(transaction);
    }

    public InventoryTransaction updateTransaction(int id, InventoryTransaction transactionDetails) {
        InventoryTransaction transaction = inventoryTransactionRepository.findById(id).orElse(null);
        if (transaction != null) {
            transaction.setProductId(transactionDetails.getProductId());
            transaction.setUserId(transactionDetails.getUserId());
            transaction.setQuantity(transactionDetails.getQuantity());
            transaction.setTransactionType(transactionDetails.getTransactionType());
            transaction.setTransactionDate(java.time.LocalDateTime.now());
            return inventoryTransactionRepository.save(transaction);
        }
        return null;
    }

    public void deleteTransaction(int id) {
        inventoryTransactionRepository.deleteById(id);
    }
}
