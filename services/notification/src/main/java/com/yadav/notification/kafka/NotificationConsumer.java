package com.yadav.notification.kafka;

import com.yadav.notification.kafka.payment.NotificationRepository;
import com.yadav.notification.kafka.payment.PaymentConfirmation;
import com.yadav.notification.notification.Notification;
import com.yadav.notification.notification.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.yadav.notification.notification.NotificationType.PAYMENT_RECEIVED;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    //private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation){
        log.info(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_RECEIVED)
                        .notificationDate(LocalDateTime.now())
                        .paymentCofirmation(paymentConfirmation)
                        .build()
        )
    }
}
