package com.group07.buildabackend.backend.utils.userType;


import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.provider.Provider;
import jakarta.persistence.PrePersist;

public class AssignUserType {

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof Customer) {
            Customer customer = (Customer) entity;
            // Extract the child table name from the class name
            String childTableName = entity.getClass().getSimpleName().toLowerCase();
            if (childTableName.equals("dependent")) {
                customer.setCustomerType("dependent");
            } else if (childTableName.equals("policy_holder")) {
                customer.setCustomerType("policy_holder");
            } else if (childTableName.equals("policy_owner")) {
                customer.setCustomerType("policy_owner");
            }
        } else if (entity instanceof Provider) {
            Provider provider = (Provider) entity;
            String childTableName = entity.getClass().getSimpleName().toLowerCase();
            if (childTableName.equals("insurance_manager")) {
                provider.setProviderType("insurance_manager");
            } else if (childTableName.equals("insurance_surveyor")) {
                provider.setProviderType("insurance_surveyor");
            } 
        }
    }
}
