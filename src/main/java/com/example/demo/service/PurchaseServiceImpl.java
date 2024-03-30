package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public boolean attemptPurchaseById(Long productId) {
        Optional<Product> currentProductOpt = productRepository.findById(productId);

        if (currentProductOpt.isPresent()) {
            Product currentProduct = currentProductOpt.get();

            if (currentProduct.getInv() > 0) {
                currentProduct.setInv(currentProduct.getInv() - 1);
                save(currentProduct);
                return true;
            } else {
                System.out.println("Product ID " + productId + " is out of stock.");
                return false;
            }
        } else {
            throw new RuntimeException("Did not find product id - " + productId);
        }
    }
}