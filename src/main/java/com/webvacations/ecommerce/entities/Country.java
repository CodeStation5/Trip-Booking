package com.webvacations.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "countries")
@Getter @Setter

public class Country {
    // customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    // creates date at data creation
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // updates data when modified
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    // Set relation by country to divisions only when relation used (.LAZY)
        // @OneToMany (mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        // private Set<Division> divisions;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Division> divisions;

}