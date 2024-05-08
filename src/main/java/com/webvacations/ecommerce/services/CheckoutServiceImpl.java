package com.webvacations.ecommerce.services;

import com.webvacations.ecommerce.dao.CartRepository;
import com.webvacations.ecommerce.dao.CustomerRepository;
import java.util.Set;
import java.util.UUID;
import com.webvacations.ecommerce.entities.Cart;
import com.webvacations.ecommerce.entities.CartItem;
import com.webvacations.ecommerce.entities.Customer;
import com.webvacations.ecommerce.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CartRepository cartRepository;
    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository)
    {
        this.cartRepository = cartRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // get order info from the dto
        Cart cart = purchase.getCart();
        // create UUID tracking number holder
        String orderTrackingNumber;
        // Check to see if the price in the cart is empty
        if (purchase.getCart().getPackage_price().intValue() == 0 ) {
            orderTrackingNumber = "The cart is empty";
            cart.setOrderTrackingNumber(orderTrackingNumber);
        }
        // If cart is empty then generate a UUID tracking number
        else {
            orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);
        }
        // String orderTrackingNumber = generateOrderTrackingNumber();
        // cart.setOrderTrackingNumber(orderTrackingNumber);
        // populate order with order items
        Set<CartItem> cartItems = purchase.getCartItems();
        // set items to the cart for purchase
        cartItems.forEach(item -> cart.add(item));
        // set the enum of the cart to ordered
        cart.setStatus(StatusType.CartStatus.ordered);
        // fill customer with the cart information
        //-----Customer customer = purchase.getCustomer();
        //-----customer.add(cart);
        // save everything to the SQL database
        Customer customer = purchase.getCustomer();
        customer.add(cart);
        cartRepository.save(cart);
        // return the tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }
    // generate random UUID, version 4
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}

