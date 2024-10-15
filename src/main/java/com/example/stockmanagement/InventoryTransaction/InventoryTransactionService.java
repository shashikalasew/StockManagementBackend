package com.example.stockmanagement.InventoryTransaction;

import com.example.stockmanagement.Product.Product;
import com.example.stockmanagement.Product.ProductRepository;
import com.example.stockmanagement.User.User;
import com.example.stockmanagement.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryTransactionService {

    @Autowired
    private InventoryTransactionRepository inventoryTransactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<InventoryTransaction> getAllTransactions() {
        return inventoryTransactionRepository.findAll();
    }

    public InventoryTransaction getTransactionById(int id) {
        return inventoryTransactionRepository.findById(id).orElse(null);
    }

    public InventoryTransaction addTransaction(InventoryTransactionDTO inventoryTransactionDTO) {
        InventoryTransaction inventoryTransaction = new InventoryTransaction();

        Product product = productRepository.findById(inventoryTransactionDTO.getProductId()).orElseThrow();
        inventoryTransaction.setProduct(product);

        User user = userRepository.findById(inventoryTransactionDTO.getUserId()).orElseThrow();
        inventoryTransaction.setUser(user);

        inventoryTransaction.setQuantity(inventoryTransactionDTO.getQuantity());
        inventoryTransaction.setTransactionType(inventoryTransactionDTO.getTransactionType());

        inventoryTransaction.setTransactionDate(java.time.LocalDateTime.now());
        return inventoryTransactionRepository.save(inventoryTransaction);
    }

    public InventoryTransaction updateTransaction(int id, InventoryTransactionDTO inventoryTransactionDTO) {

        InventoryTransaction inventoryTransaction = inventoryTransactionRepository.findById(id).orElse(null);

        if (inventoryTransaction != null) {
            Product product = productRepository.findById(inventoryTransactionDTO.getProductId()).orElseThrow();
            inventoryTransaction.setProduct(product);

            User user = userRepository.findById(inventoryTransactionDTO.getUserId()).orElseThrow();
            inventoryTransaction.setUser(user);

            inventoryTransaction.setQuantity(inventoryTransactionDTO.getQuantity());
            inventoryTransaction.setTransactionType(inventoryTransactionDTO.getTransactionType());

            inventoryTransaction.setTransactionDate(inventoryTransactionDTO.getTransactionDate());
            return inventoryTransactionRepository.save(inventoryTransaction);
        }
        return null;
    }

    public void deleteTransaction(int id) {
        inventoryTransactionRepository.deleteById(id);
    }
}
