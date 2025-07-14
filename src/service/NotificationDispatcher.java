package service;

import channel.NotificationChannel;
import enums.NotificationType;
import model.User;

public class NotificationDispatcher implements NotificationService {

    private static final int MAX_RETRIES = 3;

    @Override
    public void notifyUser(User user, String message) {
        for (NotificationType type : user.getPreference().getPreferredTypes()) {
            NotificationChannel channel;
            try {
                channel = NotificationChannelFactory.createChannel(type);
                safeSendWithRetry(channel, user, message, MAX_RETRIES);
            } catch (Exception e) {
                System.out.println("Failed to send notification to " + user.getEmail() + " with message: " + message);
            }
        }
    }

    private void safeSendWithRetry(NotificationChannel channel, User user, String message, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                channel.send(user, message);
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) {
                    System.out.println("Failed to send via channel after " + maxRetries + " attempts: " + e.getMessage());
                } else {
                    System.out.println("Retrying channel send (attempt " + attempts + " attempts: " + e.getMessage());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

}