package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor Advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    public Client(String name, String email, String phoneNumber, Advisor Advisor) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.Advisor = Advisor;
    }

    public Client() {}

    public Long getClientId() { return clientId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public Advisor getFinancialAdvisor() { return Advisor; }
    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
