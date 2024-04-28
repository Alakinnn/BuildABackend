package com.group07.buildabackend.backend.dto.insuranceClaimDTO;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;

public class InsuranceClaimMapper {

    public static InsuranceClaim toEntity(InsuranceClaimDTO dto) {
        InsuranceClaim entity = new InsuranceClaim();
        entity.setAmount(dto.getAmount());
        entity.setExamDate(dto.getExamDate());
        entity.setReceiverBankName(dto.getReceiverBankName());
        entity.setReceiverBankNumber(dto.getReceiverBankNumber());
        entity.setReceiverName(dto.getReceiverName());


        return entity;
    }

    public static InsuranceClaimDTO toDTO(InsuranceClaim entity) {
        InsuranceClaimDTO dto = new InsuranceClaimDTO();
        dto.setExamDate(entity.getExamDate());
        dto.setStatus(entity.getStatus());
        dto.setReceiverBankName(entity.getReceiverBankName());
        dto.setReceiverBankNumber(entity.getReceiverBankNumber());
        dto.setReceiverName(entity.getReceiverName());

        return dto;
    }
}
