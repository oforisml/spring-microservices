package com.sam.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository repository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        //todo: Check if email is valid
        //todo: check if email is not take


        repository.save(customer);

    }
}
