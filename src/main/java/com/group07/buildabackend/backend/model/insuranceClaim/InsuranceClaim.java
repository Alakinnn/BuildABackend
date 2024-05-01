package com.group07.buildabackend.backend.model.insuranceClaim;

import com.group07.buildabackend.backend.model.customer.Customer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class InsuranceClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String claimId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDate claimDate;

    private LocalDate examDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InsuranceClaimStatus status = InsuranceClaimStatus.NEW;

    @Column(nullable = false)
    private String receiverBankName;

    @Column(nullable = false)
    private String receiverBankNumber;

    @Column(nullable = false)
    private String receiverName;

    @Column
    private String notes;

    @OneToMany(mappedBy = "insuranceClaim", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name="CLAIM_DOCUMENT",
        joinColumns = {
                @JoinColumn(
                        name = "CLAIM_ID"
                )
        },
        inverseJoinColumns = {
                @JoinColumn(
                        name = "DOCUMENT_ID"
                )
        }

    )
    private List<Document> documents;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "customerId")
    private Customer customer;

    public InsuranceClaim() {
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public InsuranceClaimStatus getStatus() {
        return status;
    }

    public void setStatus(InsuranceClaimStatus status) {
        this.status = status;
    }

    public String getReceiverBankName() {
        return receiverBankName;
    }

    public void setReceiverBankName(String receiverBankName) {
        this.receiverBankName = receiverBankName;
    }

    public String getReceiverBankNumber() {
        return receiverBankNumber;
    }

    public void setReceiverBankNumber(String receiverBankNumber) {
        this.receiverBankNumber = receiverBankNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getNotes() {return notes;}

    public void setNotes(String notes) {this.notes = notes;}

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }
}
