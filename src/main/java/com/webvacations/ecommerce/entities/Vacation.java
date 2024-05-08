package com.webvacations.ecommerce.entities;

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
@Table(name = "vacations")
@Getter @Setter
public class Vacation {
    // customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    // Price set to 2 decimals
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    // URL is lowercase in database, uppercase in UML
    @Column(name = "image_url")
    private String image_URL;

    // creates date at data creation
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // updates date when changes made
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    // Set relation by vacation to excursions only when relation used (.LAZY)
        // @OneToMany (mappedBy = "vacation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        // private Set<Excursion> excursions;
    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<Excursion> excursions;

}