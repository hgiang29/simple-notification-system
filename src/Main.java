import enums.NotificationType;
import model.NotificationPreference;
import model.User;
import service.NotificationDispatcher;
import service.NotificationService;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationDispatcher();

        User user1 = new User("1", "alice@example.com", "1234567890",
                new NotificationPreference(Set.of(NotificationType.EMAIL)));

        User user2 = new User("2", null, "1234567890",
                new NotificationPreference(Set.of(NotificationType.EMAIL, NotificationType.SMS)));

        service.notifyUser(user1, "Welcome Alice!");
        service.notifyUser(user2, "Hello User2!");
    }
}
