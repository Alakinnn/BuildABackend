package com.group07.buildabackend.backend.dto.insuranceClaim;

import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class InsuranceClaimDTO {
    private String claimId;

    private double amount;

    private LocalDate claimDate;

    private LocalDate examDate;

    private InsuranceClaimStatus status = InsuranceClaimStatus.NEW;

    private String receiverBankName;

    private String receiverBankNumber;

    private String receiverName;

    private List<Document> documents;

    private String customerId;

    private LocalDate claimDategenerator() {
        return LocalDate.now();
    }
}
