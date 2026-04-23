package com.yadav.customer.dto;

import com.yadav.customer.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
