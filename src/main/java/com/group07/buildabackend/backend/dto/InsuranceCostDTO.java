package com.group07.buildabackend.backend.dto;

/**
 * @author Group_7
 */

public class InsuranceCostDTO implements DTO{
    private String id;

    public InsuranceCostDTO() {
    }

    public InsuranceCostDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
