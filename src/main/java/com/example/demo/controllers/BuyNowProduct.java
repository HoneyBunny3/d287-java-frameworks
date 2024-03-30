package com.example.demo.controllers;

import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String buyProductById(Model theModel, RedirectAttributes redirectAttributes, @RequestParam(value = "productID", required = false) Long productId) {
        // Attempt to purchase the product by its ID
        boolean purchaseResult = purchaseService.attemptPurchaseById(productId);

        if (purchaseResult) {
            redirectAttributes.addFlashAttribute("successMessage", "Product purchased successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Unable to purchase the product. It may be out of stock.");
        }

        return "redirect:/mainscreen";
    }
}
