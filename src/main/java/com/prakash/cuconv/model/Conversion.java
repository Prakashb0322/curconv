package com.prakash.cuconv.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conversions")
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String fromCurrency;
    private String toCurrency;
    private double convertedAmount;

    // Default Constructor
    public Conversion() {}

    // Constructor with fields
    public Conversion(double amount, String fromCurrency, String toCurrency, double convertedAmount) {
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertedAmount = convertedAmount;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
