package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;

import java.time.LocalDate;

public class InsuranceClaimMapper {

    public static InsuranceClaim toEntity(InsuranceClaimDTO dto) {
        InsuranceClaim entity = new InsuranceClaim();
        entity.setClaimId(dto.getId());
        entity.setAmount(dto.getAmount());
        entity.setClaimDate(LocalDate.now());
        entity.setExamDate(LocalDate.parse(dto.getExamDate()));
        entity.setReceiverBankName(dto.getReceiverBankName());
        entity.setReceiverBankNumber(dto.getReceiverBankNumber());
        entity.setReceiverName(dto.getReceiverName());
        entity.setDocuments(dto.getMappedDocumentList());


        return entity;
    }

    public static InsuranceClaimDTO toDTO(InsuranceClaim entity) {
        InsuranceClaimDTO dto = new InsuranceClaimDTO();
        dto.setExamDate(entity.getExamDate() + "");
        dto.setStatus(entity.getStatus());
        dto.setReceiverBankName(entity.getReceiverBankName());
        dto.setReceiverBankNumber(entity.getReceiverBankNumber());
        dto.setReceiverName(entity.getReceiverName());

        return dto;
    }
}
