package model;

public class User {
    private final String id;
    private final String email;
    private final String phoneNumber;
    private final NotificationPreference preference;

    public User(String id, String email, String phoneNumber, NotificationPreference preference) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preference = preference;
    }

    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public NotificationPreference getPreference() { return preference; }
}