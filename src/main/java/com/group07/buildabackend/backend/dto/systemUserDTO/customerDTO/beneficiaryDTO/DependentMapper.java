package com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO;

import com.group07.buildabackend.backend.model.customer.Dependent;

public class DependentMapper {
    public static Dependent toEntity(DependentDTO dependentDTO) {
        Dependent dependent = new Dependent();
        dependent.setEmail(dependentDTO.getEmail());
        dependent.setPhone(dependentDTO.getPhone());
        dependent.setLastName(dependentDTO.getLastName());
        dependent.setFirstName(dependentDTO.getFirstName());
        dependent.setAddress(dependentDTO.getAddress());
        return dependent;
    }
}
