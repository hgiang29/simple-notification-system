package channel;

import model.User;

public interface NotificationChannel {
    void send(User user, String message) throws Exception;
}
