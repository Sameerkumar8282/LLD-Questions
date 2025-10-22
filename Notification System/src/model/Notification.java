package model;

import java.time.Instant;

public class Notification {
    private final String title;
    private final String description;
    private final Instant createdAt;

    public Notification(String title, String description) {
        super();
        this.title = title;
        this.description = description;
        this.createdAt = Instant.now();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
