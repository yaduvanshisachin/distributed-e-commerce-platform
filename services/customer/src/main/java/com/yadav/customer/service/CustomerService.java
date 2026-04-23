package com.yadav.customer.service;

import com.yadav.customer.dto.CustomerRequest;
import com.yadav.customer.dto.CustomerResponse;
import com.yadav.customer.entity.Customer;
import com.yadav.customer.repository.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public String updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getId()));

        mergeCustomer(customer, request);
        customerRepository.save(customer);
        return customer.getId();
    }

    public void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.getFirstName())) {
            customer.setFirstName(request.getFirstName());

        }if(StringUtils.isNotBlank(request.getFirstName())) {
            customer.setLastName(request.getLastName());

        }if(StringUtils.isNotBlank(request.getFirstName())) {
            customer.setEmail(request.getEmail());

        }if(request.getAddress() != null) {
            customer.setAddress(request.getAddress());
        }
    }

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public CustomerResponse getCustomerById(String id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return customerMapper.fromCustomer(customer);
    }
}
