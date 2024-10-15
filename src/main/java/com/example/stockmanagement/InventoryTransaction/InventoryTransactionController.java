package com.example.stockmanagement.InventoryTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory_transaction")
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
    public InventoryTransaction addTransaction(@RequestBody InventoryTransactionDTO inventoryTransactionDTO) {

        return inventoryTransactionService.addTransaction(inventoryTransactionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryTransaction> updateTransaction(@PathVariable int id, @RequestBody InventoryTransactionDTO inventoryTransactionDTO) {
        InventoryTransaction updatedTransaction = inventoryTransactionService.updateTransaction(id, inventoryTransactionDTO);
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
