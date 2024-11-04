package com.dsa360.api.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_documents")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;
    private String documentType; // e.g., "ID Proof", "Income Proof"
    private String status; // e.g., "Uploaded", "Verified", "Rejected"

    // Many Documents belong to one Customer
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

}
