package com.example.demo.service;

import com.example.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

public interface PurchaseService {

    public List<Product> findAll();

    public Product findById(int theId);

    public void save(Product theProduct);

    public void deleteById(int theId);

    public List<Product> listAll(String keyword);

    boolean attemptPurchaseById(Long productId);}
