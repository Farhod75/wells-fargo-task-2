package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;


import java.util.Date;

@Entity

public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;
    private String name;
    private String category;
    private Date purchaseDate;
    private double purchasePrice;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    public Security(String name, String category, Date purchaseDate, double purchasePrice, int quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    public Security() {}

    public Long getSecurityId() { return securityId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public Date getPurchaseDate() { return purchaseDate; }
    public double getPurchasePrice() { return purchasePrice; }
    public int getQuantity() { return quantity; }
    public Portfolio getPortfolio() { return portfolio; }
}
