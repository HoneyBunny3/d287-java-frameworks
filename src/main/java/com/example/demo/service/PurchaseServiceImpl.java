package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductRepository productRepository;

    @Autowired
    public PurchaseServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(int theId) {
        Optional<Product> result = productRepository.findById((long) theId);
        return result.orElseThrow(() -> new RuntimeException("Did not find product id - " + theId));
    }

    @Override
    public void save(Product theProduct) {
        productRepository.save(theProduct);
    }

    @Override
    public void deleteById(int theId) {
        productRepository.deleteById((long) theId);
    }

    @Override
    public List<Product> listAll(String keyword) {
        // Assuming the 'search' method exists and is correctly implemented in your repository
        if (keyword != null) {
            return productRepository.search(keyword);
        }
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public boolean attemptPurchase(Product product) {
        // Simplified logic to demonstrate a service method
        // This method now just returns a boolean indicating the success or failure of the purchase attempt
        // The actual purchase logic would depend on your application's requirements
        if (product != null) {
            // Here, you would add your logic to check if the purchase can be made (e.g., checking stock)
            // For demonstration, let's assume the purchase can always be made
            return true;
        }
        return false;
    }
}