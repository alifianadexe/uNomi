package alifianadexe.unomi;

/**
 * Created by ditya on 5/26/18.
 */

public class UserMessage {
    String message;
    User sender;
    long createdAt;

    public UserMessage(String message, User sender, long createdAt) {
        this.message = message;
        this.sender = sender;
        this.createdAt = createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getSender() {
        return sender;
    }


}