package services;

public class NotificationService {
    public void sendBookingConfirmation(String message) {
        if (message != null && !message.isBlank()) {
            System.out.println("Notification sent: " + message);
        }
    }
}
