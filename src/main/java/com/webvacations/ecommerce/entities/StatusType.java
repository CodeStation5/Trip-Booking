package com.webvacations.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

// @Entity
// @Table (name = "status_type")
@Getter @Setter
public class StatusType {
    CartStatus cartStatus;
    public enum CartStatus{
        // The 3 constraints of the cart
        pending, ordered, canceled
    }
    public StatusType(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}