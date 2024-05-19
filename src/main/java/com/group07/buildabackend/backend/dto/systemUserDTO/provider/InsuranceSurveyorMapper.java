package com.group07.buildabackend.backend.dto.systemUserDTO.provider;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;

public class InsuranceSurveyorMapper {
    public static InsuranceSurveyor toEntity(InsuranceSurveyorDTO insuranceSurveyorDTO) {
        InsuranceSurveyor insuranceSurveyor = new InsuranceSurveyor();
        insuranceSurveyor.setEmail(insuranceSurveyorDTO.getEmail());
        insuranceSurveyor.setPhone(insuranceSurveyorDTO.getPhone());
        insuranceSurveyor.setLastName(insuranceSurveyorDTO.getLastName());
        insuranceSurveyor.setFirstName(insuranceSurveyorDTO.getFirstName());
        insuranceSurveyor.setAddress(insuranceSurveyorDTO.getAddress());
        return insuranceSurveyor;
    }
}
