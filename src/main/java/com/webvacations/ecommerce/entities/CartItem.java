package com.webvacations.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "cart_items")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartItem {
    // Customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    // Join excursion and the id of the cart item columns
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    // Many-To-Many relationship to join the cart item column with the excursion id
    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
   private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Creates date at data creation
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // Updates data when modified
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;
}