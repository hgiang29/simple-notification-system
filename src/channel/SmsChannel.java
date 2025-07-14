package channel;

import model.User;

public class SmsChannel implements NotificationChannel {

    @Override
    public void send(User user, String message) throws Exception {
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new Exception("Invalid phone number");
        }
        System.out.println("Sending SMS to " + user.getPhoneNumber() + " with message: " + message);
    }
}
