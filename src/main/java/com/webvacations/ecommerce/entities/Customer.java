package com.webvacations.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "customers")
@Getter @Setter

public class Customer {
    // customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    // mandatory entry fields cannot be null
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    // mandatory entry fields cannot be null
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    // mandatory entry fields cannot be null
    @Column(name = "address", nullable = false)
    private String address;

    // mandatory entry fields cannot be null
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    // mandatory entry fields cannot be null
    @Column(name = "phone",nullable = false)
    private String phone;

    // creates date at data creation
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // updates data when modified
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    // Set relation by customer to cart only when relation used (.LAZY)
        // @OneToMany (mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        // private Set<Cart> carts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> cart = new HashSet<>();

    public void add(Cart itemCart) {
        if (itemCart != null) {
            if (cart == null)
            {
                // If cart is not empty, create a new hashset of items that are in the cart
                cart = new HashSet<>();
            }
            // Add items to the carts Hash Set
            cart.add(itemCart);
            itemCart.setCustomer(this);
        }
    }

    // Constructor for customers with empty fields to be filled with Empty (NULL)
    public Customer() {
        firstName = "Empty";
        lastName = "Empty";
        address = "Empty";
        postal_code = "Empty";
        phone = "Empty";
        // division = "Empty";

        // Create a division with big decimal
        Division division = new Division();
        division.setId(4L);
        this.division = division;
    }
    // Constructor to enter customer information into the SQL database
    public Customer(String name, String lastName, String home, String areaCode, String phoneNum, Long division) {
        this.division = setDivision(division); //4L value
        this.postal_code = areaCode;
        this.phone = phoneNum;
        this.firstName = name;
        this.lastName = lastName;
        this.address = home;
    }
    public Division setDivision(Long id) {
        Division division = new Division();
            division.setId(id);
        return division;
    }
}
