package com.group07.buildabackend.gui.sample;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClaimCreationRequest {
    private String customerId;
    private double claimAmount;
    private LocalDate examDate;
    private String bankName;
    private String receiverName;
    private String accountNumber;
    private List<File> documents;

    public ClaimCreationRequest() {
        documents = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<File> getDocuments() {
        return documents;
    }

    public void setDocuments(List<File> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "ClaimCreationDTO{" +
                "customerId='" + customerId + '\'' +
                ", claimAmount=" + claimAmount +
                ", examDate=" + examDate +
                ", bankName='" + bankName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", documents=" + documents +
                '}';
    }
}
