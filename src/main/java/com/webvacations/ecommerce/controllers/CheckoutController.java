package com.webvacations.ecommerce.controllers;

import com.webvacations.ecommerce.services.CheckoutService;
import com.webvacations.ecommerce.services.Purchase;
import com.webvacations.ecommerce.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin ("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")

// Controller for the websites checkout feature for customers

public class CheckoutController {
    private CheckoutService checkoutService;
    @Autowired
    public CheckoutController(CheckoutService checkoutService) {this.checkoutService = checkoutService;}
    // Take PurchaseResponse and return it as JSON via the rest API
    // Places order from the cart
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;

    }

}
