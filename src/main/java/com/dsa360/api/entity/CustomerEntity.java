package com.dsa360.api.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    // Many Customers belong to one DSAAgent
    @ManyToOne
    @JoinColumn(name = "dsa_agent_id", nullable = false)
    private DSAApplicationEntity dsaAgent;

    // One Customer can have multiple Loan Applications
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanApplicationEntity> loanApplications;

    // One Customer can have multiple Documents (optional at creation)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentEntity> documents;

   
}
