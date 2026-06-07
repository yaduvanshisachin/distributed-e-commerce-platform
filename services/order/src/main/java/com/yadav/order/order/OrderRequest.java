package com.yadav.order.dto;

import com.yadav.order.entity.PaymentMethod;
import com.yadav.order.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    Integer id;

    String reference;

    @Positive(message = "Order amount should be positive")
    BigDecimal amount;

    @NotNull(message = "Payment method can not be null")
    PaymentMethod paymentMethod;

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    String customerId;

    @NotEmpty(message = "You should have at least one product")
    List<PurchaseRequest> products;
}
