package com.group07.buildabackend.backend.model.insuranceClaim;

import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "insurance_claim", schema = "public")
public class InsuranceClaim {
    @Id
    @GenericGenerator(
            name = CustomIDGenerator.GENERATOR_NAME,
            strategy = "com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = CustomIDGenerator.PREFIX_PARAM, value = "c_")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomIDGenerator.GENERATOR_NAME)
    @Column(name = "claim_id", nullable = false)
    private String claimId;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "claim_date", nullable = false)
    private LocalDate claimDate;

    @Column(name = "exam_date", nullable = false)
    private LocalDate examDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InsuranceClaimStatus status = InsuranceClaimStatus.NEW;

    @Column(name = "receiver_bank_name", nullable = false)
    private String receiverBankName;

    @Column(name = "receiver_bank_number", nullable = false)
    private String receiverBankNumber;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "note", nullable = true)
    private String note;


    @OneToMany(orphanRemoval = true, mappedBy = "insuranceClaim", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Document> documents = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "user_Id")
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

    public String getNote() {return note;}

    public void setNote(String note) {this.note = note;}

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    //    Reference for bidirectional, "One" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java

    public void addDocument(Document document) {
        if (this.documents == null) {
            this.documents = new ArrayList<>();
        }
        if (this.documents.contains(document)) {
            return;
        }
        documents.add(document);
        document.setInsuranceClaim(this);
    }

    public void removeDocument(Document document) {
        if (!documents.contains(document))
            return ;
        documents.remove(document);
        document.setInsuranceClaim(null);
    }

    public Customer getCustomer() {
        return customer;
    }

    //    Reference for bidirectional, "Many" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java
    public void setCustomer(Customer customer) {
        if (sameAsFormer(customer))
            return ;
        Customer oldCustomer = this.customer;
        this.customer = customer;
        if (oldCustomer!=null)
            oldCustomer.removeInsuranceClaim(this);
        if (customer!=null)
            customer.addInsuranceClaim(this);
    }

    private boolean sameAsFormer(Customer newCustomer) {
        return Objects.equals(customer, newCustomer);
    }
}
