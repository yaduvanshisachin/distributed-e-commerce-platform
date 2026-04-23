package com.yadav.customer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "customer")
public class Customer {
    @Id
//    @Generated(strategy = GenerationType.IDENTITY)
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private Address address;

}
