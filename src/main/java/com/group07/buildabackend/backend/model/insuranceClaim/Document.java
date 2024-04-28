package com.group07.buildabackend.backend.model.insuranceClaim;

import jakarta.persistence.*;

@Entity
@Table(name = "Document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CLAIM_ID")
    private InsuranceClaim insuranceClaim;

    public Document() {
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
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
}
