package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class InsuranceClaimDTO {

    private String id;
    private double amount;

    private String claimDate;

    private String examDate;

    private InsuranceClaimStatus status = InsuranceClaimStatus.NEW;

    private String receiverBankName;

    private String receiverBankNumber;

    private String receiverName;

    private String customerId;

    private List<File> documents;



    private Customer customer;
    private List<Document> mappedDocumentList;

    public InsuranceClaimDTO() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
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

    public List<File> getDocuments() {
        return documents;
    }

    public void setDocuments(List<File> documents) {
        this.documents = documents;
    }

    private LocalDate claimDateGenerator() {
        return LocalDate.now();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Document> getMappedDocumentList() {
        return mappedDocumentList;
    }

    public void setMappedDocumentList(List<Document> mappedDocumentList) {
        this.mappedDocumentList = mappedDocumentList;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}