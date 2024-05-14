package com.group07.buildabackend.backend.dto.systemUserDTO.provider;


import com.group07.buildabackend.backend.model.provider.InsuranceManager;

public class InsuranceManagerMapper {
    public static InsuranceManager toEntity(InsuranceManagerDTO insuranceManagerDTO) {
        InsuranceManager insuranceManager = new InsuranceManager();
        insuranceManager.setEmail(insuranceManagerDTO.getEmail());
        insuranceManager.setPhone(insuranceManagerDTO.getPhone());
        insuranceManager.setLastName(insuranceManagerDTO.getLastName());
        insuranceManager.setFirstName(insuranceManagerDTO.getFirstName());
        insuranceManager.setAddress(insuranceManagerDTO.getAddress());
        return insuranceManager;
    }
}
