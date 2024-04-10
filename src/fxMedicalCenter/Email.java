package fxMedicalCenter;

public class Email {
    private String subject;
    private String sender;
    private String date;
    private String body;

    public Email(String subject, String sender, String date, String body) {
        this.subject = subject;
        this.sender = sender;
        this.date = date;
        this.body = body;
    }

    // Getters
    public String getSubject() { return subject; }
    public String getSender() { return sender; }
    public String getDate() { return date; }
    public String getBody() { return body; }
}

