package com.webvacations.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="carts")
@Getter @Setter

public class Cart {
    // Customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType.CartStatus status = StatusType.CartStatus.pending;

    // Creates date at data creation
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // Updates data when modified
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    // Create a hashset to store items that are in the cart
    private Set<CartItem> cartItem = new HashSet<>();

    public void add(CartItem inCart) {
        if (inCart != null) {
            if (cartItem == null)
            {
                // If cartItem is not empty, create a new hashset of items that are in the cart
                cartItem = new HashSet<>();
            }
            // Add items to the carts Hash Set
            cartItem.add(inCart);
            inCart.setCart(this);
        }
    }
}