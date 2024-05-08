package com.webvacations.ecommerce.services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PurchaseResponse {
    private String orderTrackingNumber;
    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}