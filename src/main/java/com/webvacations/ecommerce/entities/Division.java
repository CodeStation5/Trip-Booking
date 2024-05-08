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
@Table (name = "divisions")
@Getter @Setter

public class Division {
    // customer_id as primary key
    @Id
    // Column of type auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    // creates date at data creation
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    // updates data when modified
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    // set relation by division to customers only when relation used (.LAZY)
        // @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        // private Set<Customer> customers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customers;

    // sets country field as long as it's not null
    @Column(name = "country_id")
    private long country_id ;
    // Method to return the customers country into the country column
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

}