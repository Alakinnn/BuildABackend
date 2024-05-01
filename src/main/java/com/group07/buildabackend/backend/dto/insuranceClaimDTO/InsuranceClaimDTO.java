package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class InsuranceClaimDTO {
    private double amount;

    private LocalDate claimDate;

    private LocalDate examDate;

    private InsuranceClaimStatus status = InsuranceClaimStatus.NEW;

    private String receiverBankName;

    private String receiverBankNumber;

    private String receiverName;

    private String notes;

    private Customer customer;

    private List<Document> documents;

    public InsuranceClaimDTO(double amount, LocalDate examDate, String receiverBankName, String receiverBankNumber, String receiverName, Customer customer) {
        this.amount = amount;
        this.examDate = examDate;
        this.claimDate = claimDateGenerator();
        this.receiverBankName = receiverBankName;
        this.receiverBankNumber = receiverBankNumber;
        this.receiverName = receiverName;
        this.customer = customer;
    }

    public InsuranceClaimDTO() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    private LocalDate claimDateGenerator() {
        return LocalDate.now();
    }
}