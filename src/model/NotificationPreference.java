package model;

import enums.NotificationType;

import java.util.Set;

public class NotificationPreference {
    private final Set<NotificationType> preferredTypes;

    public NotificationPreference(Set<NotificationType> preferredTypes) {
        this.preferredTypes = preferredTypes;
    }

    public Set<NotificationType> getPreferredTypes() {
        return preferredTypes;
    }
}
