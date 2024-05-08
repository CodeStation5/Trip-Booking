package com.webvacations.ecommerce.services;

import com.webvacations.ecommerce.entities.Cart;
import com.webvacations.ecommerce.entities.CartItem;
import com.webvacations.ecommerce.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter @Setter

public class Purchase {
    // holds information to store in cart
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}