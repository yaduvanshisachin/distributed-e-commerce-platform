package com.yadav.order.customer;

public record CustomerResponse(
        String id,

        String firstName,

        String lastname,

        String email
) {
}
