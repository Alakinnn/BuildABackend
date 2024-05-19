package com.group07.buildabackend.backend.model.insuranceClaim;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "claim_document", schema = "public")
public class Document {
    @Id
    @GenericGenerator(
            name = CustomIDGenerator.GENERATOR_NAME,
            strategy = "com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = CustomIDGenerator.PREFIX_PARAM, value = "d_")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomIDGenerator.GENERATOR_NAME)
    @Column(name = "document_id", nullable = false)
    private String documentId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "claim_id", referencedColumnName = "claim_id")
    private InsuranceClaim insuranceClaim;

    public Document() {
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
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
