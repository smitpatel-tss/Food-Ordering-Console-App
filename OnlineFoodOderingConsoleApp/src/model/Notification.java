package model;

public class Notification {
    private String message;
    private long userId;
    private String from;

    public Notification(String message, long userId, String from) {
        this.message = message;
        this.userId = userId;
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public long getUserId() {
        return userId;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return "[From " + from + "] \uD83D\uDD14 " + message;
    }
}
