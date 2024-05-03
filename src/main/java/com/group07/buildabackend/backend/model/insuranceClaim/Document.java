package com.group07.buildabackend.backend.model.insuranceClaim;

import com.group07.buildabackend.backend.model.customer.Customer;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "claim_document", schema = "public")
public class Document {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", nullable = false)
    private int documentId;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private byte[] url;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "claim_id", referencedColumnName = "claim_id")
    private InsuranceClaim insuranceClaim;

    public Document() {
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }

    public InsuranceClaim getInsuranceClaim() {
        return insuranceClaim;
    }

    //    Reference for bidirectional, "Many" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java
    public void setInsuranceClaim(InsuranceClaim insuranceClaim) {
        if (sameAsFormer(insuranceClaim))
            return ;
        InsuranceClaim oldInsuranceClaim = this.insuranceClaim;
        this.insuranceClaim = insuranceClaim;
        if (oldInsuranceClaim!=null)
            oldInsuranceClaim.removeDocument(this);
        if (insuranceClaim!=null)
            insuranceClaim.addDocument(this);
    }

    private boolean sameAsFormer(InsuranceClaim newInsuranceClaim) {
        return Objects.equals(insuranceClaim, newInsuranceClaim);
    }

}
