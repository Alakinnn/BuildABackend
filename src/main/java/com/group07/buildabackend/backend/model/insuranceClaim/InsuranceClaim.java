package com.group07.buildabackend.backend.model.insuranceClaim;

import com.group07.buildabackend.backend.model.customer.Customer;
import jakarta.persistence.*;

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
    private Date claimDate;

    private Date examDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InsuranceClaimStatus status = InsuranceClaimStatus.NEW;

    @Column(nullable = false)
    private String receiverBankName;

    @Column(nullable = false)
    private String receiverBankNumber;

    @Column(nullable = false)
    private String receiverName;

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

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
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

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
