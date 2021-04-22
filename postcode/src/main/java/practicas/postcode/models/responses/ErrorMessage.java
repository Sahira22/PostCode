package practicas.postcode.models.responses;

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String message;
    private int id;


    public Date getTimestamp() {
        return timestamp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorMessage(Date timestamp, String message, int id) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public ErrorMessage() {

    }
}
