package com.example.stockmanagement.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryTransactionController {

    @Autowired
    private InventoryTransactionService inventoryTransactionService;

    @GetMapping
    public List<InventoryTransaction> getAllTransactions() {
        return inventoryTransactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryTransaction> getTransactionById(@PathVariable int id) {
        InventoryTransaction transaction = inventoryTransactionService.getTransactionById(id);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public InventoryTransaction addTransaction(@RequestBody InventoryTransaction transaction) {
        return inventoryTransactionService.addTransaction(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryTransaction> updateTransaction(@PathVariable int id, @RequestBody InventoryTransaction transactionDetails) {
        InventoryTransaction updatedTransaction = inventoryTransactionService.updateTransaction(id, transactionDetails);
        if (updatedTransaction != null) {
            return ResponseEntity.ok(updatedTransaction);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int id) {
        inventoryTransactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
