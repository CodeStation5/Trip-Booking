package com.webvacations.ecommerce.services;

// Class to check out orders from the cart
public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}