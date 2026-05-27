package com.yadav.notification.kafka.payment;

import com.yadav.notification.notification.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
