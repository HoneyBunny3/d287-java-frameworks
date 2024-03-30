package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.PurchaseService;
import com.example.demo.service.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BuyNowProduct {

    private final PartService partService;
    private final ProductService productService;
    private final PurchaseService purchaseService;

    @Autowired
    public BuyNowProduct(PartService partService, ProductService productService, PurchaseService purchaseService) {
        this.partService = partService;
        this.productService = productService;
        this.purchaseService = purchaseService;
    }

    @GetMapping("/buyNowProduct")
    public String listPartsAndProducts(Model theModel, RedirectAttributes redirectAttributes, @RequestParam("productKeyword") String productKeyword) {
        // Use the listAll method to find products by keyword
        List<Product> products = productService.listAll(productKeyword);

        if (!products.isEmpty()) {
            // Assuming you want to process just the first product that matches the keyword
            Product product = products.get(0);

            // Attempt to purchase the product
            boolean purchaseResult = purchaseService.attemptPurchase(product);

            if (purchaseResult) {
                // If the purchase is successful, add a success message
                redirectAttributes.addFlashAttribute("successMessage", "Product purchased successfully!");
            } else {
                // If the purchase fails (e.g., out of stock), add an error message
                redirectAttributes.addFlashAttribute("errorMessage", "Product is out of stock.");
            }
        } else {
            // If no products are found with the keyword, add an error message
            redirectAttributes.addFlashAttribute("errorMessage", "Product not found.");
        }

        // Redirect back to the mainscreen, which will display the messages
        return "redirect:/mainscreen";
    }
}


