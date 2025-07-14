package channel;

import model.User;

public class EmailChannel implements NotificationChannel {

    @Override
    public void send(User user, String message) throws Exception {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new Exception("Invalid email address");
        }
        System.out.println("Sending email to " + user.getEmail() + " with message: " + message);
    }
}