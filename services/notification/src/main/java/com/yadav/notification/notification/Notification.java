package com.yadav.notification.notification;

import com.yadav.notification.kafka.order.OrderConfirmation;
import com.yadav.notification.kafka.payment.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private OrderConfirmation orderConfirmation;
    private LocalDateTime notificationDate;
    private PaymentConfirmation paymentConfirmation;
}
