package com.webvacations.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "excursions")
@Getter @Setter

public class Excursion {
    // customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    // URL is lowercase in database, but uppercase on UML chart
    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    // creates date when data created
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // updates data when modified
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems; //private set
}