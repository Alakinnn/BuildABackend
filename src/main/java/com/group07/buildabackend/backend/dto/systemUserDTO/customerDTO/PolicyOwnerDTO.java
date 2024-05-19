package com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.dto.authenticationDTO.RegisterInfoDTO;

public class PolicyOwnerDTO extends RegisterInfoDTO {
    private double yearlyRate;

    public double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }
}
