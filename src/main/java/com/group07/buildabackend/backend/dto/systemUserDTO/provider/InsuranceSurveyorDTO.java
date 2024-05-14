package com.group07.buildabackend.backend.dto.systemUserDTO.provider;

import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;

public class InsuranceSurveyorDTO extends RegisterInfoDTO {
    private String insuranceManagerId;

    public InsuranceSurveyorDTO() {
    }

    public String getInsuranceManagerId() {
        return insuranceManagerId;
    }

    public void setInsuranceManagerId(String insuranceManagerId) {
        this.insuranceManagerId = insuranceManagerId;
    }
}
